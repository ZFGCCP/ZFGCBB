package com.zfgc.zfgbb.migrator.converters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.dbo.IpAddressDboExample;
import com.zfgc.zfgbb.mappers.IpAddressDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.smf.queries.SmfMessageDistinctIpsMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IpAddressConverter extends AbstractConverter<Void> {

	private final SmfMessageDistinctIpsMapper smfDistinctIpsMapper;

	private final IpAddressDboMapper ipAddressMapper;

	private final TransactionTemplate transactionTemplate;

	@Value("${zfgbb.migrator.batch-size:5000}")
	private final int batchSize;

	private static final Logger logger = LoggerFactory.getLogger(IpAddressConverter.class);

	@Override
	public JobType getType() {
		return JobType.IPS;
	}

	@Override
	public Void convertToZfgbb() {
		List<String> ips = smfDistinctIpsMapper.selectDistinctPosterIps();
		logger.info("Beginning conversion of {} distinct IPs", ips.size());

		for (int from = 0; from < ips.size(); from += batchSize) {
			int to = Math.min(from + batchSize, ips.size());
			List<String> slice = ips.subList(from, to);
			transactionTemplate.executeWithoutResult(status -> slice.forEach(this::upsertIp));
			logger.info("Processed {}/{} IPs", to, ips.size());
		}

		transactionTemplate.executeWithoutResult(status -> upsertIp("127.0.0.1"));

		logger.info("Finished converting IP addresses");
		return null;
	}

	private void upsertIp(String ipString) {
		Cancellable.check();
		IpAddressDbo ip = new IpAddressDbo();
		ip.setIp(ipString);
		ip.setIpV6Flag(false);
		ip.setIsSpammerFlag(false);
		ip.setMigrationHash(MigrationHasher.hash(ip.getIp()
				+ ip.getIpV6Flag().toString()
				+ ip.getIsSpammerFlag().toString()));

		IpAddressDboExample ex = new IpAddressDboExample();
		ex.createCriteria().andIpEqualTo(ip.getIp()).andMigrationHashEqualTo(ip.getMigrationHash());
		IpAddressDbo existingIp = ipAddressMapper.selectByExample(ex).stream().findFirst().orElse(null);
		if (existingIp == null) {
			ipAddressMapper.insert(ip);
		} else {
			ip.setIpAddressId(existingIp.getIpAddressId());
			ipAddressMapper.updateByPrimaryKeySelective(ip);
		}
	}
}

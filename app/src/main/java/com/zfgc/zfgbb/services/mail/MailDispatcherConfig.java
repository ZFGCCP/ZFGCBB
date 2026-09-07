package com.zfgc.zfgbb.services.mail;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.zfgc.zfgbb.services.mail.MailDispatcher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableConfigurationProperties(ZfgbbMailProperties.class)
public class MailDispatcherConfig {

	@Bean
	@ConditionalOnExpression("!'${spring.mail.host:}'.isBlank()")
	public MailDispatcher smtpMailDispatcher(JavaMailSender javaMailSender,
			@Value("${spring.mail.host}") String smtpHost,
			ZfgbbMailProperties zfgbbMailProperties) {
		log.info("outbound mail will be sent through SMTP host {}", smtpHost);
		return mail -> {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(zfgbbMailProperties.from() != null ? zfgbbMailProperties.from() : "noreply@zfgc.com");
			message.setTo(mail.toEmailAddress());
			message.setSubject(mail.subject());
			message.setText(mail.body());
			javaMailSender.send(message);
		};
	}

	@Bean
	@Profile("!prod")
	@ConditionalOnExpression("'${spring.mail.host:}'.isBlank()")
	public InMemoryMailDispatcher inMemoryMailDispatcher() {
		log.info("spring.mail.host is not configured; outbound mail will be captured in memory and logged");
		return new InMemoryMailDispatcher();
	}

	public static class InMemoryMailDispatcher implements MailDispatcher {

		private final List<OutboundMail> sentMessages = new CopyOnWriteArrayList<>();

		@Override
		public void dispatch(OutboundMail mail) {
			sentMessages.add(mail);
			log.info("captured outbound mail to {} with subject '{}'", mail.toEmailAddress(), mail.subject());
			log.debug("captured outbound mail body:\n{}", mail.body());
		}

		public List<OutboundMail> sentMessages() {
			return List.copyOf(sentMessages);
		}

		public void clear() {
			sentMessages.clear();
		}
	}
}

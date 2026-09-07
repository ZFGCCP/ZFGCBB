package com.zfgc.zfgbb.services.mail;

public interface MailDispatcher {

	record OutboundMail(String toEmailAddress, String subject, String body) {}

	void dispatch(OutboundMail mail);
}

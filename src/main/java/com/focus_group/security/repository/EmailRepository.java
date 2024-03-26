package com.focus_group.security.repository;

import java.io.FileNotFoundException;
public interface EmailRepository {

    void sendSimpleEmail(final String toAddress, final String subject, final String message);
    void sendEmailWithAttachment(final String toAddress, final String subject, final String message, final String attachment) throws Exception, FileNotFoundException;
}
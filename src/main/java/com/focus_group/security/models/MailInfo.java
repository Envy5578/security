package com.focus_group.security.models;

import com.focus_group.security.enumType.TokenType;
import lombok.Data;

import java.util.Map;

@Data
public class MailInfo {
    private String recipientEmail;
    private TokenType emailType;
    private String context;
}

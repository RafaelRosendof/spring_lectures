package com.SistemLoja.SistemaLoja.Aux;

public interface EmailService {
    boolean sendEmail(String to, String subject, String body);
    // Other email-related methods can be added here
    // For example, methods for sending HTML emails, attachments, etc.
}

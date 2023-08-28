package src.Training.Ex13.Model;

import java.time.LocalDate;

public class Certificate {
    private String certificateId;
    private String certificateName;
    private String certificateRank;
    private String certificateDate;

    public Certificate(String certificateId, String certificateName, String certificateRank, String certificateDate) {
        this.certificateId = certificateId;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    public void showCertificate() {
        System.out.println("Certificate ID: " + certificateId);
        System.out.println("Certificate name: " + certificateName);
        System.out.println("Certificate rank: " + certificateRank);
        System.out.println("Certificate date: " + certificateDate);
        System.out.println();
    }
}

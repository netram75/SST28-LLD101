package com.example.reports;

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private final AccessControl accessControl = new AccessControl();

    // cache for lazy loading
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        // 1️⃣ Access control
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED for user=" + user.getName()
                    + " role=" + user.getRole()
                    + " report=" + reportId);
            return;
        }

        // 2️⃣ Lazy loading
        if (realReport == null) {
            System.out.println("[proxy] creating real report for " + reportId);
            realReport = new RealReport(reportId, title, classification);
        }

        // 3️⃣ Use cached report
        realReport.display(user);
    }
}
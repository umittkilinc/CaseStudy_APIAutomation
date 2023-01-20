package pojo;

import java.util.List;

public class AssignSession {

    private List<String> candidates;
    private String interviewer;
    private String periodStartDate;
    private String periodEndDate;
    private String interviewStartDate;
    private String examType;
    private String sessionTemplateId;
    private Boolean informCandidate;
    private String assignmentType;
    private String groupId;

    public List<String> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<String> candidates) {
        this.candidates = candidates;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(String periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public String getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(String periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public String getInterviewStartDate() {
        return interviewStartDate;
    }

    public void setInterviewStartDate(String interviewStartDate) {
        this.interviewStartDate = interviewStartDate;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getSessionTemplateId() {
        return sessionTemplateId;
    }

    public void setSessionTemplateId(String sessionTemplateId) {
        this.sessionTemplateId = sessionTemplateId;
    }

    public Boolean getInformCandidate() {
        return informCandidate;
    }

    public void setInformCandidate(Boolean informCandidate) {
        this.informCandidate = informCandidate;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}

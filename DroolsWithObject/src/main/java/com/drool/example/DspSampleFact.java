package com.drool.example;

import org.apache.poi.ss.formula.functions.T;
import org.kie.api.command.Command;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DspSampleFact implements Command<T> {
    private String definitionName;
    private String certificationService;
    private List<String> tags;
    private Map<String,String > namedTags;
    private String certificationType;
    private String certificationContentType;
    private String reviewOwner;
    private String reviewName;
    //private Date reviewExpiryDate;
    private String reviewExpiryDate;
    private int processCount;


    private String campaignNamePattern;
    private String configurationTemplate;
    private String supportEmail;
    private String campaignBatchNamePattern;
    private Boolean initiateBatch;
    private String campaignLaunch;
    private int phase1DueDays;
    private int phase2DueDays;
    private int campaignBatchDueDays;
    private Boolean prepopulateDecisions;
    private String trackingMechanism;

    public DspSampleFact(String definitionName, String certificationService, List<String> tags, Map<String, String> namedTags, String certificationType,
                         String certificationContentType, String reviewOwner, String reviewName, Date reviewExpiryDate, int processCount) {
        this.definitionName = definitionName;
        this.certificationService = certificationService;
        this.tags = tags;
        this.namedTags = namedTags;
        this.certificationType = certificationType;
        this.certificationContentType = certificationContentType;
        this.reviewOwner = reviewOwner;
        this.reviewName = reviewName;
       // this.reviewExpiryDate = reviewExpiryDate;
        this.processCount = processCount;
    }
    public DspSampleFact(String definitionName, String certificationService,String certificationType,
                         String certificationContentType, String reviewOwner, String reviewName, String reviewExpiryDate, int processCount) {
        this.definitionName = definitionName;
        this.certificationService = certificationService;
        this.certificationType = certificationType;
        this.certificationContentType = certificationContentType;
        this.reviewOwner = reviewOwner;
        this.reviewName = reviewName;
        this.reviewExpiryDate = reviewExpiryDate;
        this.processCount = processCount;
    }
    public DspSampleFact(String definitionName, String certificationService,List<String> tags,String certificationType,
                         String certificationContentType, String reviewOwner, String reviewName, String reviewExpiryDate, int processCount) {
        this.definitionName = definitionName;
        this.certificationService = certificationService;
        this.tags=tags;
        this.certificationType = certificationType;
        this.certificationContentType = certificationContentType;
        this.reviewOwner = reviewOwner;
        this.reviewName = reviewName;
        this.reviewExpiryDate = reviewExpiryDate;
        this.processCount = processCount;
    }
    public DspSampleFact(List<String> tags){
        this.tags=tags;
    }


    public String getDefinitionName() {
        return definitionName;
    }

    public String getCertificationService() {
        return certificationService;
    }

    public List<String> getTags() {
        return tags;
    }

    public Map<String, String> getNamedTags() {
        return namedTags;
    }

    public String getCertificationType() {
        return certificationType;
    }

    public String getCertificationContentType() {
        return certificationContentType;
    }

    public String getReviewOwner() {
        return reviewOwner;
    }

    public String getReviewName() {
        return reviewName;
    }

    /*public Date getReviewExpiryDate() {
        return reviewExpiryDate;
    }*/
    public String getReviewExpiryDate() {
        return reviewExpiryDate;
    }

    public int getProcessCount() {
        return processCount;
    }




    public String getCampaignNamePattern() {
        return campaignNamePattern;
    }

    public void setCampaignNamePattern(String campaignNamePattern) {
        this.campaignNamePattern = campaignNamePattern;
    }

    public String getConfigurationTemplate() {
        return configurationTemplate;
    }

    public void setConfigurationTemplate(String configurationTemplate) {
        this.configurationTemplate = configurationTemplate;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }

    public String getCampaignBatchNamePattern() {
        return campaignBatchNamePattern;
    }

    public void setCampaignBatchNamePattern(String campaignBatchNamePattern) {
        this.campaignBatchNamePattern = campaignBatchNamePattern;
    }

    public Boolean getInitiateBatch() {
        return initiateBatch;
    }

    public void setInitiateBatch(Boolean initiateBatch) {
        this.initiateBatch = initiateBatch;
    }

    public String getCampaignLaunch() {
        return campaignLaunch;
    }

    public void setCampaignLaunch(String campaignLaunch) {
        this.campaignLaunch = campaignLaunch;
    }

    public int getPhase1DueDays() {
        return phase1DueDays;
    }

    public void setPhase1DueDays(int phase1DueDays) {
        this.phase1DueDays = phase1DueDays;
    }

    public int getPhase2DueDays() {
        return phase2DueDays;
    }

    public void setPhase2DueDays(int phase2DueDays) {
        this.phase2DueDays = phase2DueDays;
    }

    public int getCampaignBatchDueDays() {
        return campaignBatchDueDays;
    }

    public void setCampaignBatchDueDays(int campaignBatchDueDays) {
        this.campaignBatchDueDays = campaignBatchDueDays;
    }

    public Boolean getPrepopulateDecisions() {
        return prepopulateDecisions;
    }

    public void setPrepopulateDecisions(Boolean prepopulateDecisions) {
        this.prepopulateDecisions = prepopulateDecisions;
    }

    public String getTrackingMechanism() {
        return trackingMechanism;
    }

    public void setTrackingMechanism(String trackingMechanism) {
        this.trackingMechanism = trackingMechanism;
    }
}

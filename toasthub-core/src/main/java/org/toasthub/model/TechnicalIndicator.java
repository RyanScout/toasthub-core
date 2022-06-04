package org.toasthub.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.toasthub.common.BaseEntity;

@Entity
@Table(name = "ta_technical_indicator")
public class TechnicalIndicator extends BaseEntity {
    private boolean flashing = false;
    private String evaluationPeriod = "";
    private String technicalIndicatorKey = "";
    private String technicalIndicatorType = "";
    private String symbol ="";
    private int checked = 0;
    private int flashed = 0;
    private int successes = 0;
    private long firstCheck = 0;
    private long lastCheck = 0;
    private long lastFlash = 0;

    private String shortSMAType;
    private String longSMAType;

    private String LBBType;
    private String UBBType;
    private BigDecimal standardDeviations;

    private Set<TechnicalIndicatorDetail> details = new LinkedHashSet<TechnicalIndicatorDetail>();

    public TechnicalIndicator() {
        super();
        this.setActive(true);
        this.setArchive(false);
        this.setLocked(false);
        this.setCreated(Instant.now());
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @OneToMany(mappedBy = "technicalIndicator", cascade = CascadeType.ALL)
    public Set<TechnicalIndicatorDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<TechnicalIndicatorDetail> details) {
        this.details = details;
    }

    public String getTechnicalIndicatorType() {
        return technicalIndicatorType;
    }

    public void setTechnicalIndicatorType(String technicalIndicatorType) {
        this.technicalIndicatorType = technicalIndicatorType;
    }

    public String getTechnicalIndicatorKey() {
        return technicalIndicatorKey;
    }

    public void setTechnicalIndicatorKey(String technicalIndicatorKey) {
        this.technicalIndicatorKey = technicalIndicatorKey;
    }

    public String getEvaluationPeriod() {
        return evaluationPeriod;
    }

    public void setEvaluationPeriod(String evaluationPeriod) {
        this.evaluationPeriod = evaluationPeriod;
    }

    @Column(name = "ubb_type")
    public String getUBBType() {
        return UBBType;
    }

    public void setUBBType(String uBBType) {
        this.UBBType = uBBType;
    }

    public BigDecimal getStandardDeviations() {
        return standardDeviations;
    }

    public void setStandardDeviations(BigDecimal standardDeviations) {
        this.standardDeviations = standardDeviations;
    }

    @Column(name = "lbb_type")
    public String getLBBType() {
        return LBBType;
    }

    public void setLBBType(String lBBType) {
        this.LBBType = lBBType;
    }

    @Column(name = "short_sma_type")
    public String getShortSMAType() {
        return shortSMAType;
    }

    public void setShortSMAType(String shortSMAType) {
        this.shortSMAType = shortSMAType;
    }

    @Column(name = "long_sma_type")
    public String getLongSMAType() {
        return longSMAType;
    }

    public void setLongSMAType(String longSMAType) {
        this.longSMAType = longSMAType;
    }

    public boolean isFlashing() {
        return flashing;
    }

    public long getLastFlash() {
        return lastFlash;
    }

    public void setLastFlash(long lastFlash) {
        this.lastFlash = lastFlash;
    }

    public long getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(long lastCheck) {
        this.lastCheck = lastCheck;
    }

    public long getFirstCheck() {
        return firstCheck;
    }

    public void setFirstCheck(long firstCheck) {
        this.firstCheck = firstCheck;
    }

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }

    public int getFlashed() {
        return flashed;
    }

    public void setFlashed(int flashed) {
        this.flashed = flashed;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public void setFlashing(boolean flashing) {
        this.flashing = flashing;
    }
}

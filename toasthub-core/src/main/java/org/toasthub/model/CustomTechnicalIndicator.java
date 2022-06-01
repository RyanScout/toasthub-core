package org.toasthub.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.toasthub.common.BaseEntity;

@Entity
@Table(name = "ta_custom_technical_indicator")
public class CustomTechnicalIndicator extends BaseEntity {
    private String name;
    private String evaluationPeriod;
    private String technicalIndicatorType;
    private String technicalIndicatorKey;
    private Set<Symbol> symbols = new LinkedHashSet<Symbol>();

    private ArrayList<Object> technicalIndicators = new ArrayList<Object>();
   

    public String getTechnicalIndicatorType() {
        return technicalIndicatorType;
    }

    @OneToMany(mappedBy = "customTechnicalIndicator", cascade = CascadeType.ALL)
    public Set<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(Set<Symbol> symbols) {
        this.symbols = symbols;
    }

    public String getTechnicalIndicatorKey() {
        return technicalIndicatorKey;
    }


    public void setTechnicalIndicatorKey(String technicalIndicatorKey) {
        this.technicalIndicatorKey = technicalIndicatorKey;
    }

    @Transient
    public ArrayList<Object> getTechnicalIndicators() {
        return technicalIndicators;
    }

    public void setTechnicalIndicators(ArrayList<Object> technicalIndicators) {
        this.technicalIndicators = technicalIndicators;
    }

    public void setTechnicalIndicatorType(String technicalIndicatorType) {
        this.technicalIndicatorType = technicalIndicatorType;
    }

    public String getEvaluationPeriod() {
        return evaluationPeriod;
    }

    public void setEvaluationPeriod(String evaluationPeriod) {
        this.evaluationPeriod = evaluationPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

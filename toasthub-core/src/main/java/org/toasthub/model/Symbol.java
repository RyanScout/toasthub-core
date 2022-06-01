package org.toasthub.model;

import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.toasthub.common.BaseEntity;

@Entity
@Table(name = "ta_symbol")
public class Symbol extends BaseEntity {
    public static final String SPY = "SPY";
    public static final String BTCUSD = "BTCUSD";
    public static final String[] CRYPTOSYMBOLS ={Symbol.BTCUSD};
    public static final String[] STOCKSYMBOLS = {Symbol.SPY};
    public static final String[] SYMBOLS = Stream.concat(Stream.of(Symbol.CRYPTOSYMBOLS), Stream.of(Symbol.STOCKSYMBOLS)).toArray(size->new String[size]);

    private String symbol;
    private CustomTechnicalIndicator customTechnicalIndicator;

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonIgnore
    @ManyToOne(targetEntity = CustomTechnicalIndicator.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_technical_indicator_id")
    public CustomTechnicalIndicator getCustomTechnicalIndicator() {
        return customTechnicalIndicator;
    }
    public void setCustomTechnicalIndicator(CustomTechnicalIndicator customTechnicalIndicator) {
        this.customTechnicalIndicator = customTechnicalIndicator;
    }


}
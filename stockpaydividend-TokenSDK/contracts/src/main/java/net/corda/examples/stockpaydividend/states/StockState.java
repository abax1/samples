package net.corda.examples.stockpaydividend.states;

import com.google.common.collect.ImmutableList;
import com.r3.corda.lib.tokens.contracts.states.EvolvableTokenType;
import net.corda.core.schemas.StatePersistable;
import net.corda.core.serialization.CordaSerializable;
import net.corda.examples.stockpaydividend.contracts.StockContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@CordaSerializable
@BelongsToContract(StockContract.class)
public class StockState extends EvolvableTokenType implements StatePersistable {

    private final UniqueIdentifier linearId;
//    private final List<Party> maintainers;
    private final Party company;
    private final int fractionDigits = 0;

    private final String symbol;
    private final String name;
    private final String currency;
    private final BigDecimal price;
    private final BigDecimal dividend;
    private final Date exDate;
    private final Date payDate;

    public StockState(UniqueIdentifier linearId, Party company, String symbol, String name, String currency, BigDecimal price, BigDecimal dividend, Date exDate, Date payDate) {
        this.linearId = linearId;
//        this.maintainers = maintainers;
        this.symbol = symbol;
        this.name = name;
        this.currency = currency;
        this.price = price;
        this.dividend = dividend;
        this.exDate = exDate;
        this.payDate = payDate;
        this.company = company;
//        company = maintainers.get(0);
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDividend() {
        return dividend;
    }

    public Date getExDate() {
        return exDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public Party getIssuer() {
        return company;
    }

    @Override
    public int getFractionDigits() {
        return fractionDigits;
    }

    @NotNull
    @Override
    public List<Party> getMaintainers() {
        return ImmutableList.of(company);
    }

}
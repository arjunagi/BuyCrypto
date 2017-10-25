import com.coinbase.api.Coinbase;
import com.coinbase.api.CoinbaseBuilder;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class BuyCrypto {

    public static void main(String[] args){
        GetApiKeys getApiKeys = new GetApiKeys();
        Coinbase cb = new CoinbaseBuilder()
                .withApiKey(getApiKeys.getApiKey(), getApiKeys.getApiSecret())
                .build();
        System.out.println("key: " + getApiKeys.getApiKey());
        System.out.println("secret: " + getApiKeys.getApiSecret());
        try {
            System.out.println(cb.getAccounts().getAccounts());
        }
        catch (Exception e) {
            System.out.println("Exception");
        }

    }
}

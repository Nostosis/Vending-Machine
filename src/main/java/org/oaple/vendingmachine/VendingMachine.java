package org.oaple.vendingmachine;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class VendingMachine {

    private final Dotenv config;
    private final ShardManager shardManager;

        public VendingMachine() throws LoginException {
            config = Dotenv.configure().load();
            String token = config.get("TOKEN");
            String prefix = config.get("PREFIX");

            DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
            builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
            builder.setActivity(Activity.customStatus("sugma balls"));
            shardManager = builder.build();
        }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
            try {
                VendingMachine bot = new VendingMachine();
        } catch (LoginException e) {
                System.out.println("dude, your token isn't right fix that shit");
        }
    }
}
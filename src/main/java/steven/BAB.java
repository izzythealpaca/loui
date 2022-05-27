package steven;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class BAB {




    public static void build(){

        String token = Token.token();
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        String BotID = String.valueOf(api.getClientId());

        api.addMessageCreateListener(event -> {

            event.getChannel().sendMessage("test! pick 1 2 or 3");
            event.getChannel().getMessagesAsStream();


        });




    }
}

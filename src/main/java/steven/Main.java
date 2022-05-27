package steven;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.interaction.SlashCommand;

import static jdk.nashorn.internal.objects.NativeString.charAt;

public class Main {

    static int rng(int min, int max){

        int num = (int)(Math.random()*((max-min)+1))+min;
        return num;
    }


    public static void main(String[] args) {
        // Insert your bot's token here
        String token = Token.token();
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        String BotID = String.valueOf(api.getClientId());


        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {

            String msg = event.getMessageContent();
            String author = event.getMessageAuthor().getIdAsString();

            int rick = rng(1,1000);
            if(rick==69){
                event.getChannel().sendMessage("never gonna give you up\nnever gonna let you down");
            }

            //relevant commands
            if(msg.contains("?time")&& !BotID.equals(author)){

                String[] split = event.getMessageContent().split(" ");
                String tz1 = split[1];
                String tz2 = split[4];
                String min = split[3];
                String hr = split[2];

                //hour but as an integer
                int frog = Integer.parseInt(split[2]);

                int z1 = 1;
                int z2 = 1;

                switch(tz1){
                    case "EST": z1=-5;
                    case "PST": z1=-8;
                }
                switch(tz2){
                    case "EST": z2=-5;
                    case "PST": z2=-8;
                }
                int dif = z1-z2;
                int hour = frog+dif;
                event.getChannel().sendMessage(hour + ":"+min);


            }
            if(msg.contains("?is")&& !BotID.equals(author)) {
                int num = rng(1,7);
                switch (num){
                    case 1: event.getChannel().sendMessage("not in my purview"); break;
                    case 2: event.getChannel().sendMessage("maybe :eyes:"); break;
                    case 3: event.getChannel().sendMessage("idk"); break;
                    case 4: event.getChannel().sendMessage("no comment :yawning_face: \nsorry my screenshotting friend"); break;
                    case 5: event.getChannel().sendMessage("i believe so"); break;
                    case 6: event.getChannel().sendMessage("no idea"); break;
                    case 7: event.getChannel().sendMessage("yes sir"); break;
                }

            }
            if(msg.contains("?wheres")&& !BotID.equals(author)) {
                int  num = rng(1,9);
                switch (num){
                    case 1: event.getChannel().sendMessage("in the flower box"); break;
                    case 2: event.getChannel().sendMessage("in the secret bunker"); break;
                    case 3: event.getChannel().sendMessage("in the shed"); break;
                    case 4: event.getChannel().sendMessage("in the camper"); break;
                    case 5: event.getChannel().sendMessage("in mexico"); break;
                    case 6: event.getChannel().sendMessage("at your moms house"); break;
                    case 7: event.getChannel().sendMessage("at the carlton reserve"); break;
                    case 8: event.getChannel().sendMessage("on the appalachian trail"); break;
                    case 9: event.getChannel().sendMessage("in the laundrie family pool"); break;
                }
            }
            if(msg.contains("?scanner")&& !BotID.equals(author)) {
                int num = rng(1,16);
                switch (num){
                    case 1: event.getChannel().sendMessage("someone shitting in a bush"); break;
                    case 2: event.getChannel().sendMessage("alligator in an apartment complex"); break;
                    case 3: event.getChannel().sendMessage("Brian Laundrie BOLO"); break;
                    case 4: event.getChannel().sendMessage("bald white man"); break;
                    case 5: event.getChannel().sendMessage("24 people fighting"); break;
                    case 6: event.getChannel().sendMessage("white man on scooter pulled over"); break;
                    case 7: event.getChannel().sendMessage("white male, green hiking backpack could be Brian laundrie"); break;
                    case 8: event.getChannel().sendMessage("twenty people fighting in front of restaurant*"); break;
                    case 9: event.getChannel().sendMessage("vehicle crashed into wall*"); break;
                    case 10: event.getChannel().sendMessage("man shot, building struck by car*"); break;
                    case 11: event.getChannel().sendMessage("report of man throwing rocks near home depot*"); break;
                    case 12: event.getChannel().sendMessage("man throwing rocks at people*"); break;
                    case 13: event.getChannel().sendMessage("five men fighting outside grocery store*"); break;
                    case 14: event.getChannel().sendMessage("person armed with sledgehammer*"); break;
                    case 15: event.getChannel().sendMessage("man armed with bolt cutter*"); break;
                    case 16: event.getChannel().sendMessage("man armed with stick*"); break;

                }
            }
            if(msg.contains("?spotted")&& !BotID.equals(author)) {
                int t1 = rng(1,5);
                int t2 = rng(1,5);
                int t3 = rng(1,4);
                int t4 = rng(1,7);

                String trait1 = "";
                String trait2 = "";
                String place = "";
                String action = "";

                switch(t1){
                    case 1: trait1="barefoot"; break;
                    case 2: trait1="bald"; break;
                    case 3: trait1="short"; break;
                    case 4: trait1="antisocial"; break;
                    case 5: trait1="gooberish"; break;
                }
                switch(t2){
                    case 1: trait2="hand tattoos"; break;
                    case 2: trait2="funny looking ears"; break;
                    case 3: trait2="a melon addiction"; break;
                    case 4: trait2="mediocre survival skills"; break;
                    case 5: trait2="the posture of a neanderthal"; break;
                }
                switch(t3){
                    case 1: place=" in Cancun, Mexico"; break;
                    case 2: place=" in North Port, Florida"; break;
                    case 3: place=" along the Appalachian Trail"; break;
                    case 4: place=" at a gas station in Georgia"; break;
                    case 5: place=" in the laundrie family pool"; break;
                }
                switch(t4){
                    case 1: action="hugging a tree"; break;
                    case 2: action="eating a melon"; break;
                    case 3: action="dressed as a cop"; break;
                    case 4: action="evading law enforcement"; break;
                    case 5: action="hanging out with his dad"; break;
                    case 6: action="sitting criss cross applesauce"; break;
                    case 7: action="making smores with his family"; break;
                }
                event.getChannel().sendMessage("A "+trait1+" white man with "+trait2+" has been spotted "+action+place);
            }
            if(msg.contains("?help")&& !BotID.equals(author)){
                event.getChannel().sendMessage("Welcome to Steven Botolino!! haha get it? like *BOT*olino?? because im a robot?? anyways... \n" +
                        "**?is** - is brian alive?? is bertolino authorized to practice law in the state of florida?? is chris an accomplice?? \n" +
                        "**?wheres** - wheres brian? wheres roberta? wheres chris? wheres the burner phone? \n" +
                        "**?scanner** - stay up to date on the sarasota county police scanner shenanigans \n" +
                        "**?spotted** - randomly generated brian sighting\n" +
                        "**?request** - request something to be added to botolino\n" +
                        "**?nik** - in case anyone tries to believe what hes saying \n" +
                        "and of course all the cute little secrets that'll show themselves with time\n" +
                        "-xoxo steve");
            }
            if(msg.contains("legal")&& !BotID.equals(author)){
                event.getChannel().sendMessage("do you even know the law");

            }
            if(msg.contains("?nik")&& !BotID.equals(author)){
                event.getChannel().sendMessage("https://media.discordapp.net/attachments/891086134803824675/896792272622985296/image0.png");
            }
            if(msg.contains("?request")&& !BotID.equals(author)){
                event.getChannel().sendMessage("<@200796115208110080> bitch hurry up and add this to botolino");
            }
            if(msg.contains("?buildabrian")){
                BAB.build();
            }
            if(msg.equalsIgnoreCase("hey steven")){
                int num = rng(1,5);

                switch(num){
                    case 1: event.getChannel().sendMessage("i know looks can be deceiving but i know i saw a light in you"); break;
                    case 2: event.getChannel().sendMessage("boy you might have me believing i don't always have to be alone"); break;
                    case 3: event.getChannel().sendMessage("i've been holding back this feeling so i've got some things to say to you"); break;
                    case 4: event.getChannel().sendMessage("why are people always leaving? i think you and i should stay the same"); break;
                    case 5: event.getChannel().sendMessage("i could give you 50 reasons why i should be the one you choose"); break;
                }

            }

            if(rng(1,1)==1) {
                //taylor commands
                if (msg.contains("face") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("With your face \uD83D\uDE42 and the beautiful eyes \uD83D\uDC40 and the conversation \uD83D\uDCAC with the little white lies \uD83E\uDD0D and the faded picture of a beautiful night \uD83C\uDF03  you *breathes* CARRY ME FROM YOUR CARR \uD83D\uDE97 UP THE STAIRS and I broke down crying :sob: was she worth this mess? \uD83E\uDDF9*breathes* after everything and that little black dress \uD83D\uDC57 \uD83D\uDDA4 after everything I must confess \uD83D\uDE4F I... neeeedd youuuu");
                }

                if (msg.contains("drunk") && !BotID.equals(author)) {
                    int r = rng(1, 10);
                    if (r == 1) {
                        event.getChannel().sendMessage("never gonna give you up\nnever gonna let you down");
                    } else {
                        event.getChannel().sendMessage("im drunk :champagne: in the back of the car:blue_car: and i cried like a baby :sob:  coming home from the bar (OH) said im fine :thumbsup: but it wasnt true :thumbsdown:  I DONT WANNA KEEP SECRETS:lock: JUST TO KEEP YOU:couple: and i snuck in through the garden gate :tulip: every night that summer:sunny: just to seal my fate :book: and i scream for whatever its worth I LOVE YOU :smiling_face_with_3_hearts:  AINT THAT THE WORST :triumph: THING YOU EVER HEARD:ear:");
                    }
                }
                if (((msg.contains("hand") || msg.contains("touch")) && !BotID.equals(author))) {
                    event.getChannel().sendMessage("your midas touch \uD83D\uDC9B on the chevy door\uD83D\uDE97  november flush \uD83C\uDF2C️ and your flannel cure \uD83E\uDDE5 \"this dorm was once a madhouse\"\uD83E\uDD2A  i made a joke \"well it made for me\":smilecry:  how evergreen our group of friends \uD83C\uDF32 don't think we'll say that word again \uD83D\uDEAB and soon they'll have the nerve to \uD83D\uDCAA deck the halls that we once walked through 1️⃣ one for the money 2️⃣ two for the show i never was ready so i watched you go \uD83E\uDD7A sometimes you just dont know the answer \uD83C\uDFC1 til someones on their knees and asks you ❓ she wouldve made such a lovely bride \uD83D\uDC70\u200D♀️ what a shame shes fucked in the head they said \uD83D\uDCAC but you'll find the real thing instead :kiss_woman_man: she'll patch up your tapestry that i shred");
                }
                if (msg.contains("bones") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("is this the end of all the endings \uD83D\uDD50 my broken bones are mending \uD83E\uDDB4 with all these nights \uD83C\uDF03 we're spending \uD83D\uDCB0 up on the roof \uD83C\uDFE9 with a schoolgirl crushhhhhhh \uD83D\uDE18 drinking beer out of plastics cupssss \uD83C\uDF7B say you fancy me not fancy stuff \uD83E\uDD11 baby all at once this is enough");
                }
                if (msg.contains("heart") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("he got my heart ❤️ beeeeaaat\uD83E\uDD41 skipping down 16th avenue \uD83C\uDFD9️ got that (uh) i mean \uD83D\uDE29  wanna see whats under that attitude :unamused: like i want you \uD83D\uDE0F bless my soul\uD83D\uDC7B i ain't gotta tell him i think he knows \uD83E\uDDE0 i think he knows\uD83E\uDD13");
                }
                if (msg.contains("cuts") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("my heart \uD83E\uDEC0 my hips \uD83D\uDE0E my body \uD83E\uDDCD\u200D♀️my love ❤️\u200D\uD83D\uDD25 trying to find \uD83E\uDD14 a part of me \uD83E\uDD0C u didn’t take \uD83D\uDE94 up ⬆️ gave up \uD83D\uDC46 on me \uD83D\uDE14 like i was a \uD83D\uDC89 bad drug \uD83D\uDC8A now i’m searching \uD83E\uDDD0 for signs \uD83D\uDED1 in a haunted \uD83D\uDC7B club \uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66 our songs \uD83C\uDFBC our films \uD83C\uDFAC united \uD83C\uDDFA\uD83C\uDDF8 we stand \uD83D\uDC6B our country \uD83E\uDD20 guess it was a lawless \uD83D\uDEA8 land quiet \uD83E\uDD2B my fears \uD83D\uDE31 with the touch of ur hand ✋ paper \uD83D\uDCC4 cut \uD83D\uDD2A stains \uD83D\uDEC1 from my paper \uD83D\uDCDD thin \uD83C\uDFC3\u200D♀️ plans \uD83D\uDCD2 my time \uD83D\uDD70 my wine \uD83C\uDF77 my spirit \uD83D\uDC7B my trust \uD83D\uDD12 tryna find \uD83D\uDD0D a part of me \uD83E\uDDB6 you didn’t take \uD83D\uDE93 up \uD83D\uDCC8 gave you \uD83E\uDD11 so much \uD83D\uDCB5 but it wasn’t enough \uD83D\uDE14  but i’ll be alright \uD83D\uDE03 it’s just a thousand \uD83D\uDCB8 cuts ✂️");
                }
                if (msg.contains("woods") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("remember \uD83E\uDDE0 when you hit the breaks too soon \uD83D\uDE99 twenty stitches in the hospital room \uD83C\uDFE5 when you started crying \uD83D\uDE2D baby i did too \uD83D\uDE22 when the sun came up \uD83C\uDF07 i was looking at you \uD83D\uDC40 remember when you couldn't take the heat\uD83D\uDD25  i walked out \uD83D\uDEB6\u200D♀️ i said im setting you free\uD83D\uDD13  but the monsters \uD83D\uDC79 turned out to be just trees\uD83C\uDF32when the sun came up ☀️ you were looking at me\uD83D\uDC41️");
                }
                if (msg.contains("fuck") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("aND YOU WERE TOSSING ME THE CAR KEYS FUCK THE PATRIARCHY KEYCHAIN ON THE GROUND WE WERE ALWAYS SKKIPPING TOWN ADN I WAS THINKING ON THE DRIVE DOWN ANYTIME NOW HES GONNA SAY ITS LOVE YOU NEVER CALLED IT WHAT IT WAS️");
                }
                if (msg.contains("dick") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("something something blackhawwks️");
                }
                if (msg.contains("chicago") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("An unidentified former Chicago Blackhawks player says in a lawsuit against the team that a then-assistant coach sexually assaulted him in 2010 during a playoff run to a Stanley Cup title and that the team did nothing after he informed a now- retired employee.️");
                }
                if (msg.contains("loui") && msg.contains("why") && !BotID.equals(author)) {
                    event.getChannel().sendMessage("reality can be whatever i want️");
                }
            }

        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
        //event.getChannel().sendMessage(""); break;

    }

}

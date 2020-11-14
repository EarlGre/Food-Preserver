package com.example.food_preserver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // nav bar for main menu
        BottomNavigationView nav = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        NavigationUI.setupWithNavController(nav, navHostFragment.getNavController());


        // search icon is clickable
        ImageView searchIcon = findViewById(R.id.SearchIcon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SearchActivity.class);
                startIntent.putExtra("com.example.test.SOMETHING", "Hello world");
                startActivity(startIntent);

                // override the transition for each activity
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        // Jar icon is clickable
        ImageView hamIcon = findViewById(R.id.LogoMenu);
        hamIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Help.class);
                startIntent.putExtra("com.example.test.SOMETHING2", "Hello world2");
                startActivity(startIntent);

                // override the transition for each activity
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}
/*
    <?xml version="1.0" encoding="UTF-8"?>

        -<resources>


-<Tutorials>

<String>https://nchfp.uga.edu/publications/uga/using_press_canners.html</String>

<String>https://nchfp.uga.edu/publications/usda/GUIDE01_HomeCan_rev0715.pdf</String>

<String>https://nchfp.uga.edu/how/dry.html</String>

</Tutorials>


        -<Vegetables>


+<Food>


-<Food>

<name>Asparagus</name>

<image>asparagus</image>

<canningMethod>Quantity: An average of 24½ pounds is needed per canner load of 7 quarts; an average of 16 pounds is needed per canner load of 9 pints. A crate weighs 31 pounds and yields 7 to 12 quarts--an average of 3½ pounds per quart.Quality: Use tender, tight-tipped spears, 4 to 6 inches long.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash asparagus and trim off tough scales. Break off tough stems and wash again. Cut into 1-inch pieces or can whole.Hot pack – Cover asparagus with boiling water. Boil 2 or 3 minutes. Loosely fill jars with hot asparagus, leaving 1-inch headspace.Raw pack – Fill jars with raw asparagus, packing as tightly as possible without crushing, leaving 1-inch headspace.Add 1 teaspoon of salt per quart to the jars, if desired. Add boiling water, leaving 1-inch headspace.Adjust lids and process as recommended in Table 1 or Table 2 according to the method of canning used.</canningMethod>

<freezingMethod>Preparation – Select young tender spears. Wash thoroughly and sort into sizes. Trim stalks by removing scales with a sharp knife. Cut into even lengths to fit containers.Water blanch small spears 2 minutes, medium spears 3 minutes and large spears 4 minutes.Cool promptly, drain and package, leaving no headspace. Seal and freeze.</freezingMethod>

<dryingMethod>Wash the asparagus and cut off the tough ends.Cut the stalks into one inch(ish) pieces. I wasn’t very exact about this.Blanch in a rolling hot water bath for 3 minutes. The timer is started from the time they are boiling, not when you put them in the water. After 3 minutes, place them into ice water to stop the cooking process.Lay them out in single layers in your dehydrator. If you have the kind with adjustable trays, you may want to rotate them around after 6 hours or so. I moved the ones closest to the heat to the top and shuffled the rest around. This picture is after about 3 hours, you can see that the thinner pieces are shrinking up.12 hours later I have dehydrated asparagus, ready to go into my cupboards for storage. I’ve used my FoodSaver to take the oxygen out of the jars so they will stay fresh.TIP: If you sort your pieces onto trays by thickness, there will be less work. The thick ones take longer to dry, and at the end, I was picking finished pieces out of the trays.</dryingMethod>

<canningUrl>https://nchfp.uga.edu/how/can_04/asparagus_spears.html</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/asparagus.html</freezingUrl>

<dryingUrl>https://preparednessmama.com/dehydrating-asparagus/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Beans: Green, Snap, or Wax</name>

<image>beans_green_snap_or_wax</image>

<canningMethod>Quantity: An average of 14 pounds is needed per canner load of 7 quarts; an average of 9 pounds is needed per canner load of 9 pints. A bushel weighs 30 pounds and yields 12 to 20 quarts – an average of 2 pounds per quart.Quality: Select filled but tender, crisp pods. Remove and discard diseased and rusty pods.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash beans and trim ends. Leave whole or cut or snap into 1-inch pieces.Hot pack –Cover with boiling water; boil 5 minutes. Fill jars loosely with beans, leaving 1-inch headspace. Add 1 teaspoon of canning salt per quart to the jar, if desired. Cover beans with hot cooking liquid, leaving 1-inch headspace.Raw pack – Fill jars tightly with raw beans, leaving 1-inch headspace. Add 1 teaspoon of canning salt per quart to the jar, if desired. Add boiling water, leaving 1-inch headspace.Adjust lids and process in a pressure canner following the recommendations in Table 1 or Table 2 according to the type of canner being used. (There is no safe option for processing green beans in a boiling water canner.)</canningMethod>

<freezingMethod>Preparation – Select young tender pods when the seed is first formed. Wash in cold water, snip and cut into 2 to 4-inch lengths.Water blanch 3 minutes. Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

<dryingMethod>You can dry beans and peas in an oven if you don’t have a dehydrator. The best type of oven is an electric fan oven but a standard or a gas oven will do the job. Please note that beans dried in this manner are not suitable for sprouting as the blanching kills the germ.Pod your peas or beans and drop into cold water. The reason for this is you may well have a few pea maggots and they will float out in the water.Now blanch for about three minutes. Since they inevitably slip through the holes in a blanching basket, we just drop them straight into the blanching water and then use a fine sieve to fish them out.Don’t cool after blanching, just dry them on a towel before spreading onto trays and drying in the oven. The ideal is to dry at a temperature starting at 50°C/120°F/Gas Mark 0 and then increase the temperature slowly up to 65°C/150°F/Gas Mark 0.The beans and peas are dry when they are quite crisp. Depending on their size, this takes between 2-3 hours. Pack in tightly corked bottles or airtight containers and store in a dry, dark place.</dryingMethod>

<canningUrl>https://nchfp.uga.edu/how/can_04/beans_snap_italian.html</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/bean_green.html</freezingUrl>

<dryingUrl>https://www.allotment-garden.org/recipe/drying-dehydrating/drying-beans-peas/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Beans: Lima, Butter, or Pinto</name>

<image>beans_lima</image>

<canningMethod>Beans or Peas - Shelled, Dried: All VarietiesQuantity: An average of 5 pounds is needed per canner load of 7 quarts; an average of 3¼ pounds is needed per canner load of 9 pints--an average of ¾ pounds per quart.Quality: Select mature, dry seeds. Sort out and discard discolored seeds.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Place dried beans or peas in a large pot and cover with water. Soak 12 to 18 hours in a cool place. Drain water. To quickly hydrate beans, you may cover sorted and washed beans with boiling water in a saucepan. Boil 2 minutes, remove from heat, soak 1 hour and drain. Cover beans soaked by either method with fresh water and boil 30 minutes. Add ½ teaspoon of salt per pint or 1 teaspoon per quart to the jar, if desired. Fill jars with beans or peas and cooking water, leaving 1-inch headspace.Adjust lids and process as recommended in Table 1 or Table 2 according to the method of canning used.</canningMethod>

<freezingMethod>Preparation – Harvest while the seed is in the green stage. Wash, shell and sort according to size.Water blanch small beans 2 minutes, medium beans 3 minutes and large beans 4 minutes. Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze. </freezingMethod>

<dryingMethod>You can dry beans and peas in an oven if you don’t have a dehydrator. The best type of oven is an electric fan oven but a standard or a gas oven will do the job. Please note that beans dried in this manner are not suitable for sprouting as the blanching kills the germ.Pod your peas or beans and drop into cold water. The reason for this is you may well have a few pea maggots and they will float out in the water.Now blanch for about three minutes. Since they inevitably slip through the holes in a blanching basket, we just drop them straight into the blanching water and then use a fine sieve to fish them out.Don’t cool after blanching, just dry them on a towel before spreading onto trays and drying in the oven. The ideal is to dry at a temperature starting at 50°C/120°F/Gas Mark 0 and then increase the temperature slowly up to 65°C/150°F/Gas Mark 0.The beans and peas are dry when they are quite crisp. Depending on their size, this takes between 2-3 hours. Pack in tightly corked bottles or airtight containers and store in a dry, dark place.</dryingMethod>

<canningUrl>https://nchfp.uga.edu/how/can_04/beans_peas_shelled.html</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/bean_lima.html</freezingUrl>

<dryingUrl>https://www.allotment-garden.org/recipe/drying-dehydrating/drying-beans-peas/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Beets</name>

<image>beets</image>

<canningMethod>Quantity: An average of 21 pounds (without tops) is needed per canner load of 7 quarts; an average of 13-1/2 pounds is needed per canner load of 9 pints. A bushel (without tops) weighs 52 pounds and yields 15 to 20 quarts--an average of 3 pounds per quart.Quality: Beets with a diameter of 1 to 2 inches are preferred for whole packs. Beets larger than 3 inches in diameter are often fibrous.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Trim off beet tops, leaving an inch of stem and roots to reduce bleeding of color. Scrub well. Cover with boiling water. Boil until skins slip off easily; about 15 to 25 minutes depending on size. Cool just enough to handle without burning yourself, then remove skins, and trim off stems and roots. The beets should remain warm or hot going into the jars. Leave baby beets whole. Cut medium or large beets into 1/2-inch cubes or slices. Halve or quarter very large slices. Add 1 teaspoon of salt per quart to the jar, if desired. Fill jars with hot beets and fresh hot water that has been brought to a boil first (not the water you used to boil the beets with), leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

<freezingMethod>Preparation – Select deep, uniformly-red, tender, young beets. Wash and sort according to size. Trim tops, leaving 1/2 inch of stems and tap root, to prevent bleeding of color during cooking.Cook in boiling water until tender-for small beets 25 to 30 minutes; for medium beets 45 to 50 minutes.Cool promptly in cold water. Peel, remove stem and tap root, and cut into slices or cubes. Package, leaving ½-inch headspace. Seal and freeze.</freezingMethod>

<dryingMethod>Dried beets usually are reconstituted or added to soups and stews. If properly dried, beets retain their flavor and much of their nutritional value.Blanch the beets in boiling water for 20 minutes and transfer them into a container of ice water. Scrape the peels from the beets.Trim off the stems and taproot and slice the beets into uniform, 1/8-inch-wide strips. Chop the beets into 1/4-inch-thick pieces or grate them using a box grater.Heat the food dehydrator to 120 degrees Fahrenheit and lay the beet pieces about 1/4 inch apaprt from each other on the drying trays.If using an oven, heat it to the Warm setting. Place the beets on cooling racks covered with a piece of cheesecloth.Dry beet strips until they are brittle or crisp, about 8 hours, in the dehydrator; dry chopped or grated beets for four to six hours.If using the oven, dry beet strips for 4 hours and shredded beets for 2 hours.THINGS YOU WILL NEEDKnifeBox grater (optional)Food dehydratorCooling or baking rack (optional)Cheesecloth (optional)TIPPack the dried and cooled beets into dry, airtight containers or plastic bags that seal. Store the dried beets in a cool, dark place. Check the beets after a few days and then periodically to make sure they are completely dried. Use dried beets within six to 12 months. Discard the beets and disinfect the containers if you see signs of mold or other spoilage. Soak dried beets in cold water for one hour to reconstitute. Add dry or reconstituted beets to soups or stews. Dried beets will double in size when reconstituted.</dryingMethod>

<canningUrl>https://nchfp.uga.edu/how/can_04/beets.html</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/beet.html</freezingUrl>

<dryingUrl>https://homesteady.com/13406978/how-to-dry-out-beets</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Broccoli</name>

<image>broccoli</image>

<canningMethod>Spicy Quick Pickled BroccoliIngredients1 pound fresh broccolisprinkling of sea salt3/4 cup unseasoned rice vinegar3 tablespoons sesame oil1 1/2 teaspoons chili paste1 teaspoon garlic, minced1 teaspoon granulated sugarInstructionsFill a large bowl with ice water and set aside.Cut the broccoli into uniform spears. Rinse, drain, add them to a large bowl. Set aside.Place a steamer rack into a pot with the water level just below it. Over high heat, bring the water to a boil and then add the broccoli to the rack, sprinkle it with salt and cover. Turn the heat to low and steam just until the broccoli is tender, 4 to 5 minutes.Drain the broccoli and immediately add it to the bowl of ice water. Leave it for about 5 minutes, drain again, pat dry with a kitchen towel, and set aside. (The ice water "shocks" the broccoli, which stops the cooking process and helps keep the color bright.)In a medium-sized mixing bowl, whisk the vinegar with the sesame oil, chili paste, garlic, and sugar. Pour this mixture into a heavy-duty zip-lock bag and add the broccoli. Seal the bag, removing as much air as possible and place it in a bowl (in case it leaks), in the refrigerator.Let the broccoli marinate for about 1 hour, drain and serve.</canningMethod>

<freezingMethod>Preparation – Select firm, young, tender stalks with compact heads. Remove leaves and woody portions. Separate heads into convenient-size sections and immerse in brine (4 teaspoons salt to 1 gallon water) for 30 minutes to remove insects. Split lengthwise so flowerets are no more than 1 1/2 inches across.Water blanch 3 minutes in boiling water or steam blanch 5 minutes.Cool promptly, drain and package, leaving no headspace. Seal and freeze.</freezingMethod>

<dryingMethod>Harvest your broccoli fresh from the garden or get it fresh from the farmer’s market.On the same day you bring it in, wash it under cold running water.Put it in a sink of cold water to which you’ve added 1 tbsp. of Himalayan salt. Allow it to soak for 1 hour. This is to remove any of the squeamy, green broccoli worms. Don’t skip this step with organic broccoli, even store bought.Drain it.Cut the flower from the stems and chop them finely, about the size you’d want to use in soups or stews.Shred the stems with a box grater.Put the flowers on a dehydrator tray in a single layer.Put the shredded stems on another dehydrator tray in a thin layer.Put all the trays in your dehydrator and process on medium heat over night.In the morning, shuffle the trays so that the front of the trays is at the back of the dehydrator, and the top trays are shuffled to the bottom.Allow to dry for another 4 to 6 hours or until dry, and brittle.Turn off the dehydrator and allow the contents to cool naturally.Check for doneness. When done your vegetables should be dry and brittle. There should be no coldness when you touch them. If there is any coolness at all, process them for another 2 hours and test again for doneness. Coolness is an indication of internal moisture.Once your dried vegetables are completely done and cooled, store in glass jars with tight fitting lids. Don’t trust a snap lid with a canning ring. Bugs have been known to infiltrate jars through the gap at the top of the canning ring.The plastic lids that they sell for dry storage in canning jars is a better choice to keep bugs out.</dryingMethod>

<canningUrl>https://cookingontheweekends.com/spicy-quick-pickled-broccoli/</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/broccoli.html</freezingUrl>

<dryingUrl>https://joybileefarm.com/drying-broccoli-food-storage/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Brussel Sprouts</name>

<image>brussel_sprouts</image>

<canningMethod>Zesty Pickled Brussels SproutsIngredients:2 pounds Brussels sprouts, trimmed and cut in half5 1-pint canning jars with lids and rings5 cloves garlic, divided1 1/4 teaspoons red pepper flakes, divided5 cups water5 cups distilled white vinegar7 tablespoons pickling saltDirections:Soak Brussels sprouts in a large bowl filled with lightly salted water for about 15 minutes. Drain well.Sterilize the jars and lids in boiling water for at least 5 minutes.Divide the drained Brussels sprouts evenly between jars, filling the jars about 3/4-inch from the top.Place 1 garlic clove and 1/4 teaspoon red pepper flakes in each jar.Bring vinegar, water, and pickling salt to a boil in a large pot over medium-high heat until the salt is dissolved, about 5 minutes.Pour the vinegar mixture into the jars, filling the jars to within 1/4 inch of the top.Run a knife or a thin spatula around the insides of the jars after they have been filled to remove any air bubbles.Wipe the rims of the jars with a moist paper towel to remove any food residue. Top with lids, and screw on rings.Place a rack in the bottom of a large stockpot, and fill stockpot halfway with water.Bring to a boil over high heat, then carefully lower the jars into the pot using a holder. Leave a 2-inch space between the jars. Pour in more boiling water if necessary, until the water level is at least 1 inch above the tops of the jars. Bring the water to a full boil, cover the pot, and process for 10 minutes.Remove the jars from the stockpot and place onto a cloth-covered or wood surface, several inches apart, until cool.Once cool, press the top of each lid with a finger, ensuring that the seal is tight (lid does not move up or down at all). Store in a cool, dark area, and wait at least 3 weeks before opening.</canningMethod>

<freezingMethod>Preparation – Select green, firm and compact heads. Examine heads carefully to make sure they are free from insects. Trim, removing coarse outer leaves. Wash thoroughly. Sort into small, medium and large sizes.Water blanch small heads 3 minutes, medium heads 4 minutes and large heads 5 minutes. Cool promptly, drain and package, leaving no headspace. Seal and freeze. </freezingMethod>

<dryingMethod>1. Selection & IngredientsSelect vegetables at peak quality and flavor. Do not use vegetables that show signs of decay, mold, or bruising. These defects may affect all pieces being dried.Ice is needed for cooling the Brussels sprouts following blanchingCitric acid (optional)-1 teaspoon (4 grams) in a gallon of water for blanching step as an anti-microbial agent2. EquipmentClean, food-grade dehydrator or oven with drying trays or racks that allow for good air circulation.Many types of food dehydrators can be used and are explained in detail in Food Dehydrators.Conditioning containersLarge, clean plastic or glass container with lidStorage containersClean, dry home canning jars, plastic freezer containers with tight-fitting lids or plastic freezer bagsVacuum packaging is also a good storage optionLarge covered cooking pot (for blanching)Metal blanching basket, cheesecloth or mesh bag (for blanching vegetables prior to drying)Colander, slotted spoon or strainerLarge bowl (for cooling blanched vegetables in ice water)Hot padsCutting boardKnifeTimer or clock3. Prepare IngredientsPre-treating vegetables by blanching is recommended to enhance quality and safety. Blanching improves color and texture, relaxes tissues so pieces dry faster, reduces the time needed to rehydrate vegetables, and helps to destroy potentially harmful bacteria.Thoroughly wash Brussels sprouts.Cut in half lengthwise through the stem.Fill large cooking pot with 1 gallon of water and bring to a rolling boil.If desired, add 1 teaspoon (4 grams) citric acid to the water as an anti-microbial agent.Put no more than four cups of the vegetable pieces in a blanching basket, or a piece of cheesecloth or cloth mesh bag with ends secured.Lower vegetable bag into boiling water, making sure water covers the vegetables. Shake bag so hot water reaches all pieces, if necessary.Blanch for time shown in table below for your elevation:Blanching Time for DryingBelow 5,000 ft. 5,000 ft. and above4 1/2- 5 1/2 minutes 5 1/2- 6 1/2 minutesStart timing as soon as water returns to a boil.Montior heat to ensure continuous boiling.Remove vegetables from boiling water and submerge briefly in a large bowl of ice, only long enough to stop the cooking action.NOTE: Do not cool to room temperature.Drain on paper towel or cloth.Repeat process until entire batch is blanched and cooled.4. DryArrange blanched Brussels sprouts in single layers on drying trays.Dry at 140 degrees F (60°C) in an oven or dehydrator.If necessary, turn large pieces over every 3 to 4 hours during the drying period.Vegetables can scorch easily toward the end of drying, so monitor more closely as drying nears completion.Dried Brussels sprouts should be tough to brittle.Total Drying Time: 12-18 hours in a dehydrator (may take up to twice as long in a conventional oven)5. ConditionCondition Brussels sprouts by placing cooled, dried vegetables loosely in large plastic or glass containers, about two-thirds full.Lightly cover and store in a dry, well-ventilated place for 4 to 10 days.Stir or shake containers daily to separate pieces.NOTE: If beads of moisture form inside the container return Brussels sprouts to drying trays for further drying, then repeat the conditioning step.6. StoreStore small amounts of cooled, conditioned dried vegetables in moisture-vapor-proof containers or bags.Label packages with name of product, date and method of pretreatment and drying.Store in a cool, dry, dark place or in the refrigerator or freezer.Properly stored, dried vegetables keep well for six to 12 months.Discard foods that have off odors or show signs of mold.7. Using Dried VegetablesDried vegetables can be eaten ‘as is’ as a snack or part of a meal.Adding dried vegetables directly to soups and stews is the simplest way to rehydrate vegetables.</dryingMethod>

<canningUrl>https://www.allrecipes.com/recipe/220205/zesty-pickled-brussels-sprouts/</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/brussel_sprouts.html</freezingUrl>

<dryingUrl>https://apps.chhs.colostate.edu/preservesmart/produce/drying/brussels-sprouts/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Cabbage or Chinese Cabbage</name>

<image>cabbage_or_chinese_cabbage</image>

<canningMethod>SauerkrautIngredients:5 lbs cabbage (5 lbs)3 tablespoons pickling saltInstructions:Take cabbage, discard outer leaves.Wash heads under running water, shake excess water off.With a large knife such as a French knife, quarter the cabbage heads.Cut out and discard the cores.Slice the quartered cabbage into slices about 2 mm (.07 inches) thick (the thickness of a US / Cdn quarter or a 10 p piece.)Put cabbage either into a very large bowl or directly into the container you are going to use to ferment it in - whatever you prefer to be working in.Sprinkle the salt over and mix in.Some sources say to let it stand a bit so the salt will start drawing at least a bit of liquid out. Some suggest 10 minutes; the All New Ball says cover it and let stand for an hour.Begin pounding / crushing the cabbage, and keep on crushing it until a good amount of liquid has been released from the leaves.Ideally, you are going to be aiming for enough released liquid to cover the cabbage once in the fermenting container, but you may rarely get it at this point -- don't worry.Add to fermenting container, if it's not already.If you are doubling, tripling or quadrupling the recipe, start the next batch of cabbage now, then add to container.Repeat until you have prepped all the cabbage you planned to.When you are finished crushing, if the cabbage is not already in the fermentation container, move it all there.Be sure to leave a gap of 10 to 12 cm (4 to 5 inches) between the cabbage in the container, and the top rim of the container as headspace.If you have more cabbage than that, you'll need another container.If the juice you were able to produce was not sufficient to cover the cabbage, then make a brine (see directions below) and use that to top up with. (To be clear: you are not aiming to fill the container to the top rim with liquid; you are after enough liquid to completely submerge all the cabbage by 2 to 5 cm / 1 to 2 inches.) FIRST, though, see Linda Ziedrich suggestion in Brine section: she suggests waiting 24 hours to see if it will produce enough juice on its own before adding the extra brine.Cover cabbage with some sort of weight (see Weights Options below) to keep it safely below the surface of the liquid.Cover container with a large towel.Let ferment for 3 to 4 weeks or until cabbage is translucent.During fermentation, you may or may not need to check the cabbage frequently. It depends on the weights you use (see Weights Options below).</canningMethod>

<freezingMethod>Preparation – Frozen cabbage or Chinese cabbage are suitable for use only as a cooked vegetable.Select freshly picked, solid heads. Trim coarse outer leaves from head. Cut into medium to coarse shreds or thin wedges, or separate head into leaves. Water blanch 1½ minutes.Cool promptly, drain and package, leaving ½-inch headspace. Seal and freeze. </freezingMethod>

<dryingMethod>PreparationPrepping this great vegetable for dehydrating is fairly simple:Remove the outer leaves from each head of cabbage.Stem and core the larger cabbage varieties. Those parts don’t dehydrate or reconstitute that well.Clean and wash, then let stand or pat dry.Cut or process the head into quarters, and then into thin strips approximately 1/8” wide. Length can vary with no problem.Remember, there is no need to blanch the cabbage prior to dehydrating.DehydratingArrange the the slices onto your dehydrator trays. They can nestle close together, even overlap just a touch.Turn on your dehydrator to the recommended temperature. Usually between 125 degrees and 135 degrees Fahrenheit.Dry between 8 – 11 hours depending on the thickness of the cabbage leaves. Don’t forget to rotate your dehydrator trays for even drying.After your cabbage pieces are fully dry, I suggest letting the cabbage stand at room temp for a night before packaging them for storage.Storing dehydrated cabbageThere are a wide variety of choices as far as storage containers. For me, it depends on what my goals are. If it is long term storage, then I use everything from canning jars to mylar bags. I make sure to add some type of oxygen absorbers in each container. I don’t suggest using plastic containers of any kind. I have had leakage problems no matter how carefully I store and stack them.</dryingMethod>

<canningUrl>https://www.healthycanning.com/home-canned-sauerkraut/#The_recipe</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/cabbage.html</freezingUrl>

<dryingUrl>https://thesurvivalmom.com/how-to-dehydrate-cabbage/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Carrots</name>

<image>carrots</image>

<canningMethod>Sliced or DicedQuantity: An average of 17-1/2 pounds (without tops) is needed per canner load of 7 quarts; an average of 11 pounds is needed per canner load of 9 pints. A bushel (without tops) weighs 50 pounds and yields 17 to 25 quarts – an average of 2-1/2 pounds per quart.Quality: Select small carrots, preferably 1 to 1-1/4 inches in diameter. Larger carrots are often too fibrous.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash, peel, and rewash carrots. Slice or dice.Hot pack – Cover with boiling water; bring to boil and simmer for 5 minutes. Fill jars, leaving 1-inch of headspace.Raw pack – Fill jars tightly with raw carrots, leaving 1-inch headspace.Add 1 teaspoon of salt per quart to the jar, if desired. Add hot cooking liquid or water, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

<freezingMethod>Preparation – Select young, tender, coreless, medium length carrots. Remove tops, wash and peel. Leave small carrots whole. Cut others into thin slices, 1/4-inch cubes or lengthwise strips.Water blanch small whole carrots 5 minutes, diced or sliced 2 minutes and lengthwise strips 2 minutes.Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

<dryingMethod>Wash and scrub carrots in cold water. Cut the tops off. Chop into small chunks... about 1/4 inch or so.I have tried chopping the carrots up in a food processor. It is faster, but the carrots will end up being much smaller pieces. Almost too small.It works.... but by the time they are dried, the carrots are extremely small.When they get this small they will tend to fall through even a screen in a dehydrator. I prefer to use a knife and make my pieces a bit larger.Use a mandolin slicer to make nice thin slices, then just coarsely chop these slices. You could also just do it all with a good sharp knife.Blanch carrots for 3 to 4 minutes. This will help the carrots to dehydrate quicker. It releases some of the juices and stops enzyme actions.To blanch simply plunge in boiling water using a blancher makes this easy. Start counting time as soon as you dunk the carrots.Then plunge them into cold or even ice water. This cools the carrots and stops the cooking process. Use a strainer and then let the carrots drain well before spreading them for the dehydrator.Drain well and spread in a single layer on a dehydrator tray. Be sure the carrots are spread enough that air flows freely around them.Dry at 125 degrees until dry and crispy. Check every so often (every couple of hours) and stir them around, rotate trays if needed. This will encourage them to dry evenly.Dehydrated carrots are done when they are crispy dry. Store in an airtight container. Turn your container over on the counter for a day or two and check for moisture building up in the jar. If you notice any wetness..... they are not dry enough. Return them to the dehydrator.</dryingMethod>

<canningUrl>https://nchfp.uga.edu/how/can_04/carrots_sliced.html</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/carrot.html</freezingUrl>

<dryingUrl>https://www.simplycanning.com/how-to-dry-vegetables.html</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Cauliflower</name>

<image>cauliflower</image>

<canningMethod>https://recipes.howstuffworks.com/pickled-cauliflower-recipe.htm</canningMethod>

<freezingMethod>Preparation – Choose compact white heads. Trim off leaves and cut head into pieces about 1 inch across. If necessary to remove insects, soak for 30 minutes in solution of salt and water (4 teaspoons salt per gallon water). Drain.Water blanch for 3 minutes in water containing 4 teaspoons salt per gallon water.Cool promptly, drain and package, leaving no headspace. Seal and freeze.</freezingMethod>

<dryingMethod>What you’ll need:1 medium head cauliflower1 teaspoon turmeric powder1/4 teaspoon salt, or to tasteMethod:1. Remove the outer leaves and stalk from the cauliflower head. Cut into florets.2. Place the cauliflower florets in a food processor. Pulse until you get the texture of rice or couscous.3. Cook in your favorite way: by frying, microwaving or roasting. I prefer roasting. It gives to cauliflower rice light, fluffy texture and pleasant nutty flavor.Preheat oven to 400F/200C. Line a baking sheet with parchment paper. Pour the riced cauliflower onto prepared baking sheet.Sprinkle with turmeric and season to taste. Mix well and then spread out evenly. Roast for about 15 minutes, mixing once or twice during cooking. Remove from the oven and let cool slightly.4. Spread the cauliflower rice on dehydrator trays covered with non-stick sheets or parchment paper.5. Cover with mash sheet to prevent scattering of small dried cauliflower rice pieces throughout the dehydrator.6. Dehydrate at 135F/57C for about 4-8 hours until completely dry and crunchy.7. Let cool, then pack into airtight container or zip-lock bag. Store in dry, dark and cool place.Rehydration:Dehydrated cauliflower rice rehydrates very quickly. Just mix it with equal quantity of hot water, stir well, and let sit in a cozy for 5 to 10 minutes. If you’ll mix it with other ingredients such as meat or vegetables, rehydration may take a bit longer. </dryingMethod>

<canningUrl>https://recipes.howstuffworks.com/pickled-cauliflower-recipe.htm</canningUrl>

<freezingUrl>https://nchfp.uga.edu/how/freeze/cauliflower.html</freezingUrl>

<dryingUrl>https://www.trail.recipes/blog/how-to-make-dehydrated-cauliflower-rice/</dryingUrl>

<type>vegetable</type>

</Food>


        -<Food>

<name>Celery</name>

<image>celery</image>

<canningMethod>The USDA never backed canning plain celery or had developed directions for it. Also see https://www.healthycanning.com/canning-celery/</canningMethod>

<freezingMethod>Celery loses its crispness when frozen. The frozen product is suitable only for cooked dishes.Preparation – Select crisp, tender stalks, free from coarse strings. Wash thoroughly, trim and cut stalks into l-inch lengths.Water blanch for 3 minutes. Cool promptly, drain and package leaving no headspace. Seal and freeze.</freezingMethod>

<dryingMethod>What You NeedCeleryDehydrator or ovenLarge potWaterStoveStorage jarHow to Prepare Celery for DehydratingBring a large pot of water to a boil.While it is heating, wash the celery. Cut off the whitish bottom ends and the leafy top ends. Save the ends and leaves for soup stock by freezing them. If you keep adding them to a container in the freezer, you will never have to buy celery just to make stock.Cut the celery stalks into thirds. Dump them into the boiling water, and leave for 1 minute. Drain them, and immediately run them under cold water or immerse in ice water to stop the residual heat from continuing to cook the celery.Slice the blanched celery into 1/2-inch-thick crescents. At this point, you can stop and store the blanched, sliced celery in the refrigerator for up to 24 hours before proceeding with the dehydration.Dehydrator MethodArrange the celery pieces on the trays of a dehydrator, leaving 1/4-inch space on all sides between the pieces. If you are using an oven rather than a dehydrator, arrange the pieces on a screen placed over a baking rack.Dry at 135 F until the celery is crispy-dry. This usually takes 6 to 8 hours.Oven MethodIf you are using an oven that doesn't have a temperature setting below 150 F (many don't), set it to the lowest heat, and prop the oven door open with a dish towel or wooden spoon. Note that this wastes a lot of energy. If you are planning to dry a lot of food, a dehydrator is a worthwhile investment both financially and environmentally.When the celery is crispy-dry (usually takes 6 to 8 hours), remove the trays or baking sheet(s), and let them cool at room temperature for 10 minutes.StorageTransfer the dried celery to glass jars, and screw on the lids.Label the jars with the contents and the date that you dehydrated the celery.Store away from direct light or heat.</dryingMethod>

        <canningUrl>https://www.healthycanning.com/canning-celery/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/celery.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/how-to-make-dehydrated-celery-1327565#:~:text=Arrange%20the%20celery%20pieces%20on,takes%206%20to%208%20hours.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Corn</name>

        <image>corn</image>

        <canningMethod>Quantity: An average of 31½ pounds (in husk) of sweet corn is needed per canner load of 7 quarts; an average of 20 pounds is needed per canner load of 9 pints. A bushel weighs 35 pounds and yields 6 to 11 quarts – an average of 4½ pounds per quart.Quality: Select ears containing slightly immature kernels or of ideal quality for eating fresh. Canning of some sweeter varieties or too immature kernels may cause browning. Can a small amount, check color and flavor before canning large quantities.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Husk corn, remove silk, and wash. Blanch 3 minutes in boiling water. Cut corn from cob at about three-fourths the depth of kernel. Caution: Do not scrape cob.Hot pack – To each clean quart of kernels in a saucepan, add 1 cup of hot water, heat to boiling and simmer 5 minutes. Add 1 teaspoon of salt per quart to the jar, if desired. Fill jars with corn and cooking liquid, leaving 1-inch headspace.Raw pack – Fill jars with raw kernels, leaving 1-inch headspace. Do not shake or press down. Add 1 teaspoon of salt per quart to the jar, if desired.Add fresh boiling water, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 or Table 2 according the the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Select only tender, freshly-gathered corn in the milk stage. Husk and trim the ears, remove silks and wash.Corn-on-the-cob – Water blanch small ears (1¼ inches or less in diameter) 7 minutes, medium ears (1¼ to 1½ inches in diameter) 9 minutes and large ears (over 1½ inches in diameter) 11 minutes. Cool promptly and completely to prevent a "cobby" taste. Drain and package. Seal and freeze.Whole Kernel Corn – Water blanch 4 minutes. Cool promptly, drain and cut from cob. Cut kernels from cob about 2/3 the depth of the kernels. Package, leaving ½-inch headspace. Seal and freeze.Cream Style Corn – Water blanch 4 minutes. Cool promptly and drain. Cut kernel tips and scrape the cobs with the back of a knife to remove the juice and the heart of the kernel. Package, leaving ½-inch headspace. Seal and freeze.Another way to prepare cream style corn for freezing is to cut and scrape the corn from the cob without blanching. Place the cut corn in a double boiler, and heat with constant stirring for about 10 minutes or until it thickens; allow to cool by placing the pan in ice water. Package in moisture-vapor resistant containers, leaving ½-inch headspace. Seal and freeze. </freezingMethod>

        <dryingMethod>Step 1Husk the corn. If you can, do this outside.Step 2Blanch corn by bringing bring a large pot of water to boil. Once boiling add cobs of corn to water, wait for water to return to boiling then boil for 4 minutes. Remove from heat and immediately cool in an ice water bath and drain well. Blanching ensures the aging enzymes in corn (the ones that turn corn from sweet to starchy) are destroyed and keeps your corn tasty sweet and delicious.Do NOT add salt to water as this will toughen the corn.Step 3Cut corn off the cobs by placing cob end in the opening of a bundt pan. The pan will catch all the kernels and provide a steady base for the cob of corn as you run a sharp knife down the sides of the cob between the cob and the corn kernels.Alternatively, cut a slice off the bottom of the corn cob to give you a level surface so you can hold the cob vertically on a cutting board without it wobbling. Run the knife down the sides of the cob.Step 4Spread corn kernels on dehydrator trays in a single layer to allow for plenty of air circulation. Break any large pieces of corn apart into separate kernels for even drying.Step 5Dehydrate at 125°F or 52°C until corn kernels are hard and dry. Most vegetables like corn should be dried so they are brittle enough that they would shatter if hit with a hammer. Depending on humidity levels this can take 8-12 hours.Step 6Allow corn to cool thoroughly before storing in airtight jars. Simply turn the dehydrator off and let them sit for another 60 minutes. This ensures that there won’t be any condensation build up on the inside of the jars.Step 7Store in airtight containers in a cool, dry, dark place for up to one year. </dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/corn_kernel.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/corn.html</freezingUrl>

        <dryingUrl>https://www.gettystewart.com/how-to-dehydrate-corn/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Cucumbers</name>

        <image>cucumbers</image>

        <canningMethod>PicklesIngredientsIngredients for Canned Cucumbers:6 bay leaves (1 per jar)1/2 Tbsp peppercorn (5 per jar)6 Dill Stems with Flowers cut into 3" pieces (1 full stem per jar)12 garlic cloves halved (2 cloves per jar)2 inch horseradish root chopped and divided, optional but nice6 lbs small cucumbers well rinsed with ends trimmedIngredients for Pickling Brine:8 cups water1/3 cup granulated sugar6 Tbsp pickling salt (or 1/3 cup)6 cups distilled white Vinegar (5% acidity)Tools Needed for Canning:6 Quart-sized wide-mouth mason jars with rings and new lids1 large Stock Pot (20Qt+) with Rack (or a canner)1 jar lifter to safely transfer the jarsInstructionsHow to Sterilize Canning Jars and Lids:Wash jars and lids with soap and water.Place jars and lids in a pot of water, bring to a boil then reduce heat, cover and simmer 10 minutes. Drain the water carefully then your jars and lids are ready to use.How to Make Homemade Pickles:Divide bay leaves, peppercorns, dill stems, garlic and horseradish (optional) into the bottoms of 6 Quart-sized jars. Pack cucumbers tightly into jars.In a medium pot, combine 8 cups water, 1/3 cup sugar, 6 Tbsp salt and 6 cups vinegar. Bring pickling juice to a boil then pour over cucumbers leaving 1/2” of space at the top. Screw the lids on enough to keep a tight seal in place but don't over-tighten them since air bubbles need to be able to escape.Place jars in a canner or large pot lined with a wire rack at the bottom. Once all of the jars are in the pot, add boiling hot water, to cover jars with 1-2 inches of water. Process/boil for 15 minutes.Carefully remove jars from the water using a jar lifter and leave at room temperature undisturbed for 12-24 hours. You may hear a pop when the jars fully seal. After 24 hours, check that the seal has formed by pushing down on the center of the lid - it should not move at all. If the seal does not form, refrigerate pickles and enjoy within 3 months.</canningMethod>

        <freezingMethod>One way to freeze cucumbers is to slice them and put the cucumber slices on a baking the sheet lined with parchment paper. Pop the baking sheet into the freezer for a few hours. Put the frozen cucumber slices in a ziplock bag. Label the bag and put it back into the freezer.</freezingMethod>

        <dryingMethod>Spice Mixes:Spicy:These are great just eaten from a bowl, or tossed onto soups. They make a great compliment to cream soups like cream of mushroom, or cream of chicken. Toss 1/2 pound of sliced cucumbers in:1/4 tsp salt1 tsp chili powder1 tsp paprikaHerb:These are wonderful served alongside light meals like vegetable soups or grilled chicken or fish. Feel free to substitute your favorite herbs, such as dill and parsley, or basil and oregano.1/4 tsp salt1/4 tsp pepper (optional)1 tsp dried thyme1 tsp dried rosemarySweet:The lightness of cucumbers lends itself to a sweet flavor mix. These make nice snacks, and I think they’d be a great addition sprinkled over spicier dishes as a way to offset the heat, like a spicy goulash or bowl of hot chili:1/2 tsp sugar1 tsp cocoa powder1 tsp cinnamonInstructions:For all of the flavor combinations, I dried enough cucumbers for one or two servings (1/2 a pound of cucumber); feel free to adjust the recipes to make more. The process is the same:1. Slice the cucumbers thin with either a sharp knife or a food mandolin. I sliced mine with a sharp knife to about 1/8 of an inch thick.2. Toss your sliced cucumbers in your spice mix.3. Place your sliced, spiced cucumbers in a single layer in your food dehydrator or (like I did) on a rack placed over a cookie sheet. Cucumbers seem to stick more than other foods I’ve dried, so make sure you oil the rack lightly.4. Dry for several hours in the oven at 170F (or the lowest setting of your oven), or however long your food dehydrator takes to dry foods.5. Eat as chips, or save to sprinkle over savory stews, salads, or toss into soups.</dryingMethod>

        <canningUrl>https://natashaskitchen.com/canned-dill-pickle-recipe/</canningUrl>

        <freezingUrl>https://www.schneiderpeeps.com/can-you-freeze-cucumbers/</freezingUrl>

        <dryingUrl>https://www.keyingredient.com/recipes/3465755032/3-recipes-for-dried-cucumbers/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Eggplant</name>

        <image>eggplant</image>

        <canningMethod>INGREDIENT LIST FOR CANNED EGGPLANTS IN VINEGAR WITH CHILLI8 mini purple eggplantsSalt1 clove of garlic1 cup (25cl) of white vinegar3 cups (75cl) of waterGood quality olive oil1 bird pepper, whole or groundOreganoDIRECTIONS1. Wash the small eggplants and cut them into strips. Here I kept the slices attached by the stem. You can do the same with larger eggplants, but you’ll have to peel them.2. Eggplant is best when the bitter juice is drawn out before canning. Put eggplants in a colander and sprinkle with a good amount of salt. Allow the eggplant to drain for 1h, up to 1h30. For larger specimens, wait for 3h.3. Once this time has elapsed, rinse eggplants stripes and press them between your hands several times to drain as much water as possible.4. Bring water and vinegar to a boil in a saucepan and then soak eggplant for 2-3 minutes.5. Collect eggplant using a slotted spoon. Mix or layer your ingredients in the sterilized canning jar. Place them with a few pieces of peeled garlic, oregano, and a little bit of ground or minced pepper between each layers of eggplant. Press to pack it well, then cover with olive oil. Add a ladle of the boiled water/vinegar mix (or a tablespoon, depending on the size of the jar).6. Close the lid tightly and store in a cool, dark place for at least one week. The longer it sits, the better. Enjoy on fresh bread!Tips:Regarding the water/vinegar mix, the 3/1 ratio is approximative and works well for small eggplants. Too much vinegar will alter the taste. But if you want to use bigger eggplants, just make sure to respect the principle of 2 parts water for 1 part vinegar (2/1 ratio).</canningMethod>

        <freezingMethod>Preparation – Harvest before seeds become mature and when color is uniformly dark. Wash, peel and slice 1/3-inch thick. Prepare quickly, enough eggplant for one blanching at a time.Water blanch 4 minutes in 1 gallon of boiling water containing 1/2 cup lemon juice. Cool, drain and package, leaving 1/2-inch headspace. Seal and freeze.For Frying – Pack the drained slices with freezer wrap between slices. Seal and freeze.</freezingMethod>

        <dryingMethod>Step One: Slice or Dice Your Eggplants, One at a TimeSelect firm, fresh eggplants, as they will preserve better than ones that are already wrinkled or deteriorating.Prepare only one eggplant at a time, as the flesh discolors extremely fast.I have chosen to dice mine. You may slice them, or cut them into any shape you please. You may peel your eggplants, if you wish.Step Two: Blanch Your Eggplant PiecesYou may steam blanch your eggplant pieces 3 minutes, or boil them 1 minute. Add citric acid or Fruit Fresh to the water, to help the eggplants hold their color. Blanching is supposed to help vegetables keep better once frozen or dried.Immediately put the eggplant pieces in ice-cold water (called "shocking"), to stop the cooking. I usually use a sinkful of water, but a bowl works, too.After a few batches, the water will discolor. That's alright. Add ice cubes with each batch, or pour off the water and get fresh.Step Three: Dry Your Eggplant PiecesI use a commercial dehydrator to dry many of my foods. I have never tried sun-drying eggplant. Scoop each batch onto the screen then spread around as evenly as you can.You don't need much room between pieces (they will shrink a lot, you know), but make sure you don't have any "clumps" of stuck-together pieces. Set dehydrator temperature to 140* F., and dry until quite hard.Step Four: Remove from Screens or Trays, and Package in Bags or JarsAfter most of the pieces are dry, pick out any that aren't, to dry some more. Tip remaining pieces to the center of the screen and place in an airtight bag or glass jar. In this bag are about three large eggplants.Jars are usually better than bags for keeping dried food in. If there is a pinhole leak, or you don't get the bag sealed 100%, that means your food is steadily deteriorating.</dryingMethod>

        <canningUrl>https://www.eatwell101.com/canned-eggplant-recipe</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/eggplant.html</freezingUrl>

        <dryingUrl>https://delishably.com/vegetable-dishes/How-to-Dry-Eggplant-An-Illustrated-Guide</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Garlic</name>

        <image>garlic_in_oil</image>

        <canningMethod>IngredientsGarlic heads broken apart and cloves peeledDistilled vinegarLarge pot for boiling the vinegarJars for storing the garlicInstructionsBreak apart your heads of garlic and peel the cloves. Place the peeled cloves of garlic in a large mixing bowl and fill with water. Use your fingertips to scrub any dirt off of the cloves. Once the cloves are cleaned, transfer them to a large strainer and rinse well.Depending on when your garlic was harvested, you might have very few brown spots on the cloves. My garlic was harvested late this year, so the ends were quite brown with some spots on the cloves as well. Use a small paring knife to trim the spots and then transfer the cleaned and trimmed cloves back to the strainer. Rinse again.Bring the vinegar to a boil in a large pot. For several hundred cloves of garlic, I used about 8 cups of vinegar. Place the clean garlic cloves into small jars. (I prefer to use small vs large jars to avoid contaminating a huge amount if the jar is open for too long in the refrigerator.) I filled 10 half pint jars with garlic. Once the vinegar has boiled, pour it over the garlic and screw the lids on tight.Let the jars come to room temperature on the counter overnight and then store in the refrigerator. This will keep in the refrigerator for up to a year. Enjoy!</canningMethod>

        <freezingMethod>Research performed by the National Center for Home Food Preservation confirmed that mixtures of garlic in oil stored at room temperature are at risk for the development of botulism.Garlic-in-oil should be made fresh and stored in the refrigerator at 40°F or lower for no more than 4 days. It may be frozen for long term storage for up to several months. Package in glass freezer jars or plastic freezer boxes, leaving ½-inch headspace. Label, date and freeze.</freezingMethod>

        <dryingMethod>Drying garlic is an easy and safe way to keep garlic indefinitely. Choose fresh, firm, flavourful cloves with no bruises and follow these simple directions.Peel the garlic cloves.Slice the garlic thinly. A food processor works well.Dry the garlic until crisp. In a dehydrator you have a choice of faster, hotter drying or slower, cooler drying. We dry our garlic for two days at about 45°C (115°F).Store the garlic. Dried garlic may be stored at room temperature in an airtight container. If you store the dried garlic in the freezer in the form of flakes, and then grind it close to the time when you will be using the garlic it will keep its amazing freshness for more than a year.Grind the garlic. A blender gives you a mixture of powder and granules which you can separate using a fine and a coarse seive. A coffee grinder not used for coffee is good for turning garlic flakes into powder.</dryingMethod>

        <canningUrl>https://barefeetinthekitchen.com/preserving-garlic-for-winter/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/garlic_oil.html</freezingUrl>

        <dryingUrl>https://www.garlicfarm.ca/garlic-drying.htm</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Greens (including Spinach)</name>

        <image>greens_including_spinach</image>

        <canningMethod>Quantity: An average of 28 pounds is needed per canner load of 7 quarts; an average of 18 pounds is needed per canner load of 9 pints. A bushel weighs 18 pounds and yields 3 to 9 quarts – an average of 4 pounds per quart.Quality: Can only freshly harvested greens. Discard any wilted, discolored, diseased, or insect- damaged leaves. Leaves should be tender and attractive in color.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash only small amounts of greens at one time. Drain water and continue rinsing until water is clear and free of grit. Cut out tough stems and midribs. Place 1 pound of greens at a time in cheesecloth bag or blancher basket and steam 3 to 5 minutes or until well wilted. Add 1/2 teaspoon of salt to each quart jar, if desired. Fill jars loosely with greens and add fresh boiling water, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 and Table 2.</canningMethod>

        <freezingMethod>Preparation – Select young, tender green leaves. Wash thoroughly and cut off woody stems. Water blanch collards 3 minutes and all other greens 2 minutes.Cool, drain and package, leaving 1/2-inch headspace. Seal and freeze. </freezingMethod>

        <dryingMethod>To dehydrate the greens, place them in single layers on the dehydrator trays. Depending on your dehydrator model, (and whether or not it has a fan), the greens will dry in 8-24 hours at low to medium heat (115-125 F). Keep in mind that the lower the temperature, the longer the drying time.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/spinach_greens.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/greens.html</freezingUrl>

        <dryingUrl>https://learn.eartheasy.com/articles/supercharge-your-meals-with-dehydrated-greens/#:~:text=To%20dehydrate%20the%20greens%2C%20place,the%20longer%20the%20drying%20time.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Fresh Herbs</name>

        <image>fresh_herbs</image>

        <canningMethod>Mint JellyIngredients1 1/2 cups of firmly packed mint leaves2 1/4 cups of water2 tblsp lemon juice3 1/2 cups of sugar (I use raw, unbleached sugar)Green food coloring (optional, the mint jelly is clear otherwise)1 pouch of liquid pectin4 8-ounce jelly jars (approx)InstructionsThe key…Freshness!!! It is important to select the freshest produce when making any meal and even more so when working with herbs. Although I keep a small herb garden handy on my back deck, I head to my garden in the morning to select fresh mint.After cutting, or purchasing, your mint be sure to clean and rise it with cold water in a colander being sure to remove any leaves that look ill in appearance. I purposely select only the finest leaves when canning. Using your thumb nail, pinch off each perfect lead you intend to use in the jelly and set aside. Do not use the stem. After measuring 1 1/2 cups of firmly packed mint leaves, chop finely.In a large saucepan, (I prefer stainless steel) combine mint and 2 1/4 cups of water. Bring to a boil. Remove from heat, cover and let steep for 10 minutes.Place cheesecloth over your canning funnel or sieve and have a large glass dish ready to catch the liquid. I use my 2 cup glass measuring cup so I can measure the liquid without having to dump the liquid a second time possibly losing precious liquid. Gently and slowly pour the mint water over the cheesecloth. Let your funnel/sieve sit over the glass dish until enough liquid has dripped giving you a full 1 3/4 cups. </canningMethod>

        <freezingMethod>Preparation – Wash, drain and pat dry with paper towels. Wrap a few sprigs or leaves in freezer wrap and place in a freezer bag. Seal and freeze.These can be chopped and used in cooked dishes. These usually are not suitable for garnish, as the frozen product becomes limp when it thaws. </freezingMethod>

        <dryingMethod>What You'll NeedEquipment / ToolsPruners or garden scissorsAirtight containersString or rubber bandsMaterialsPaper bagContainer labelsPaper towelsInstructionsHow to Dry Fresh HerbsGather your clippings.Check in about two weeks to see how things are progressing. Keep checking weekly until your herbs are dry enough to crumble and ready to store.Remove any dry or diseased leaves from the cut herbs. Yellowed leaves and leaves spotted by disease are not worth drying. Their flavor has already been diminished by the stress of the season.Shake the branches gently to remove any insects. There are always hitchhikers, and since you won't be thoroughly washing the stems, get rid of as many as you can right now.Make sure the herbs are dry. If you've picked your herbs while the plants are dry, you should be able to simply shake off any excess soil. Rinse with cool water only if necessary and pat dry with paper towels. Hang or lay the herb branches out where they will get plenty of air circulation so they can dry out quickly. Wet herbs will mold and rot.Remove the lower leaves along the bottom inch or so of the stem. You can use these leaves fresh or dry them separately.Bundle four to six stems together and tie as a bunch. You can either use a string or a rubber band. The bundles will shrink as they dry and the rubber band will loosen, so check periodically to make sure that the bundle is not slipping. If you are trying to dry herbs that have a high water content, make small bundles so they get air flow between the branches and do not rot.Punch or cut holes in a paper bag, then label the bag with the name of the herb you are drying.Place the herb bundle upside down into the bag. You can include the loose leaves you removed from the bottom inch of the stems if you like.Secure the bag by gathering the end around the bundle and tie it closed. Make sure the herbs are not crowded inside the bag.Hang the bag upside down in a warm, airy room.How to Store HerbsOnce you've completed the drying process:Store your dried herbs in airtight containers. Small canning jars work nicely. Zippered plastic bags will work, as well. Your herbs will retain more flavor if you store the leaves whole and crush them when you are ready to use them.Label and date your containers.Discard any dried herbs that show the slightest sign of mold. It will only spread.Place containers in a cool, dry place away from direct sunlight. There are now amber-colored canning jars that are designed to block sunlight.</dryingMethod>

        <canningUrl>https://canningdiva.com/canning-mint-jelly/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/herbs.html</freezingUrl>

        <dryingUrl>https://www.thespruce.com/how-to-dry-and-store-herbs-1403397</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Horseradish</name>

        <image>horseradish</image>

        <canningMethod>Ingredients1 cup grated horseradish1⁄2 cup white vinegar1/4 teaspoon sea salt or 1/4 teaspoon kosher saltDIRECTIONSgrated horseradish (trim skin with veggie peeler, wash and grind in a meat grinder or do in food processor) (I hear wearing goggles helps your eyes) Mix thoroughly with vinegar and salt using amounts as needed and pack into hot sterile jars.I usually process in a hot water bath for 10 min for pints.It is best to still store in the fridge, I think for colouring.If you want it creamy a client told me to put the whole mixture back into the food processor and puree a bit, I havent tried it yet but he said that is how the big companies do it.The heat all depends on the growing season and sometimes it gets hotter after stored.</canningMethod>

        <freezingMethod>Freezing is not recommended for whole pieces. However, grated fresh horseradish may be frozen up to 6 months. You may wish to flash-freeze it by the tablespoon in ice trays or on waxed paper, and then place in a sealed plastic bag in the freezer. Keep in mind that it will lose pungency when frozen.</freezingMethod>

        <dryingMethod>Because jarred horseradish -- the kind that you usually see in the grocery store -- typically contains additives such as salt and vinegar, start with a fresh horseradish root for optimal results with pure horseradish flavor. Select a mature, firm root. Scrub the outside of the root with a vegetable brush and rinse the horseradish under running water. Trim the top from the root and slice it into 1/4-inch pieces or grate it using a box grater or a food processor.As a general rule, Deanna DeLong, author of _How to Dry Food_s, recommends drying horseradish at 150 degrees F for one hour, and then at 130 degrees F until the horseradish is dry and brittle. Some methods that you can use include:using a dehydrator, which is one of the easiest and most energy efficient ways to dry horseradish. Most dehydrators feature adjustable temperature controls and a built in fan to speed the process. Start the horseradish at 150 F, then lower the temperature to 130 F for another five to nine hours.oven-dehydrating horseradish, which requires no special equipment. If your oven doesn't go as low as 130 F, set it to the lowest possible setting and crack the door to maintain lower temperatures. Place a thermometer in the oven to monitor the heat. Arrange the horseradish on baking sheets lined with parchment paper and check it often for doneness, especially if you're drying it at a higher temperature, which takes less time.drying horseradish outside, which is best done on a dry, sunny day that's 85 F or warmer. Arrange the horseradish on a slatted tray or wire racks. Place it directly in the sun and allow it to dry in the sunlight, flipping the slices occasionally for even drying. Drying times vary widely depending on air circulation and humidity levels, but typically average four to 10 hours.</dryingMethod>

        <canningUrl>https://www.food.com/recipe/horseradish-canned-30959</canningUrl>

        <freezingUrl>https://www.thespruceeats.com/horseradish-storage-and-selection-1807773#:~:text=Freezing%20is%20not%20recommended%20for,will%20lose%20pungency%20when%20frozen.</freezingUrl>

        <dryingUrl>https://www.leaf.tv/articles/how-to-dry-horseradish-into-powder/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Kohlrabi</name>

        <image>kohlrabi</image>

        <canningMethod>INGREDIENTS1 bulb kohlrabi, greens removed, bulb peeled½ cup distilled white vinegar½ cup water1 teaspoon kosher salt1 teaspoon sugar2 cloves garlic, peeled½ teaspoon peppercorns, lightly crushedINSTRUCTIONSSlice your kohlrabi into ½-inch thick slices, then stack, and cut into ½-inch thick batons. Place them in a clean canning jar.In a non-reactive saucepan, bring the water, vinegar, salt, and sugar to a boil, and simmer for one minute or until the sugar and salt are dissolved. Remove from heat and add the garlic and peppercorns.Pour the hot liquid including the garlic and peppercorns over the kohlrabi. Let cool to room temperature, then cover and refrigerate.</canningMethod>

        <freezingMethod>Preparation – Select stems when fully grown but tender. Cut off tops and roots. Wash and peel off the tough bark. Leave whole or dice in 1/2 inch cubes. Water blanch whole 3 minutes and cubes 1 minute.Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Ingredients1 medium kohlrabi1/2 cup apple cider vinegar1 teaspoon sea saltPreparationSlice kohlrabi about 1/8-inch thick.Lay them out flat on a baking sheet.Pour on the vinegar and sprinkle on the salt.Cover, or put them in an enclosed place, like an oven, and let them sit and soak for about 2 hours, or until they get flimsy and translucent.Lay them out flat on a ventilated dehydrator sheet, and dry until crispy, up to 48 hours.</dryingMethod>

        <canningUrl>https://alexandracooks.com/2015/06/14/csa-week-1-anchovy-butter-pickled-kohlrabi-turnips-what-to-do-with-them/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/kohlrabi.html</freezingUrl>

        <dryingUrl>https://www.onegreenplanet.org/vegan-recipe/kohlrabi-chips/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Mushrooms</name>

        <image>mushrooms</image>

        <canningMethod>Mushrooms - Whole or SlicedQuantity: An average of 14-1/2 pounds is neeed per canner load of 9 pints; an average of 7-1/2 pounds is needed per canner load of 9 half-pints – an average of 2 pounds per pint.Quality: Select only brightly colored, small to medium-size domestic mushrooms with short stems, tight veils (unopened caps), and no discoloration. Caution: Do not can wild mushrooms.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Trim stems and discolored parts. Soak in cold water for 10 minutes to remove dirt. Wash in clean water. Leave small mushrooms whole; cut large ones. Cover with water in a saucepan and boil 5 minutes. Fill jars with hot mushrooms, leaving 1-inch headspace. Add 1/2 teaspoon of salt per pint to the jar, if desired. For better color, add 1/8 teaspoon of ascorbic acid powder, or a 500-milligram tablet of vitamin C. Add fresh hot water, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Choose mushrooms free from spots and decay. Sort according to size. Wash thoroughly in cold water. Trim off ends of stems. If mushrooms are larger than 1 inch across, slice them or cut them into quarters.Mushrooms can be steamed or heated in fat in a fry pan. Steamed mushrooms will keep longer than those heated in fat.To Steam – Mushrooms to be steamed have better color if given anti-darkening treatment first. To do this, dip for 5 minutes in a solution containing 1 teaspoon lemon juice or 11/2 teaspoons citric acid to a pint of water.Then steam whole mushrooms 5 minutes, buttons or quarters 31/2 minutes and slices 3 minutes. Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze.To Heat in Fry Pan – Heat small quantities of mushrooms in margarine or butter in an open fry pan until almost done.Cool in air or set pan in which mushrooms were cooked in cold water. Pack into containers, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>IngredientsFresh shiitake mushroomsInstructionsStart with fresh mushrooms (this method will not work with mushrooms past their prime), and wipe them clean with a lightly dampened towel. Do NOT wash them under running water.Transfer them to a container that allows air to circulate around them, such as a mesh colander, or a baking rack set on top of a baking sheet. Do not overcrowd the mushrooms.Place them in a well ventilated area (any area of the house with a ready supply of fresh air), preferably in the sun if possible. Allow them to air dry for 7-10 days, until they do not give when squeezed. Drying time will vary based on humidity levels and the size of the mushrooms.To expedite the process, you can partially dehydrate them in the oven before air drying. Place in an oven heated to 175 degrees F/80 degrees C for 2 hours, flipping them halfway through. Then transfer to a colander to air-dry for another 3-5 days.Store them in a sealed container for up to 2 years (be sure the mushrooms are COMPLETELY dried before sealing them away).Note: To rehydrate the mushrooms for cooking, soak in warm water for 1-2 hours. Use the soaking liquid in cooking if possible, as it is full of flavor. </dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/mushrooms.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/mushroom.html</freezingUrl>

        <dryingUrl>https://thewoksoflife.com/dried-mushrooms/#:~:text=Place%20in%20an%20oven%20heated%20to%20175%20degrees%20F%2F80,dried%20before%20sealing%20them%20away).</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Okra</name>

        <image>okra</image>

        <canningMethod>Quantity: An average of 11 pounds is needed per canner load of 7 quarts; an average of 7 pounds is needed per canner load of 9 pints. A bushel weighs 26 pounds and yields 16 to 18 quarts – an average of 1-1/2 pounds per quart.Quality: Select young, tender pods. Remove and discard diseased and rust-spotted pods.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash pods and trim ends. Leave whole or cut into 1-inch pieces. Cover with hot water in a saucepan. Boil 2 minutes and drain. Fill prepared jars with hot okra, leaving 1-inch headspace. If desired, add 1⁄2 teaspoon salt to pint jars; 1 teaspoon of salt to quart jars. Cover okra in jars with fresh boiling water, leaving 1-inch headspace. Remove air bubbles; wipe jar rims with clean, damp paper towel.Adjust lids and process following the recommendations in Table 1 and Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>The smooth type varieties freeze as well as or better than the ridged varieties because they do not split as easily. Preparation – Select young tender pods and separate into small pods (4 inches or under) and large pods. Wash. Remove the stems at the end of the seed cells, being careful not to expose the seed cell.Water blanch small pods 3 minutes and large pods 4 minutes.Cool promptly and drain. Leave whole or slice crosswise. Package, leaving 1/2-inch headspace. Seal and freeze.For Frying – Wash and remove stems. blanch small pods 3 minutes and large pods 4 minutes. Cool promptly and drain. Slice crosswise and dredge with meal or flour. Spread in a single layer on shallow trays. Place in freezer just long enough to freeze firm. Package quickly, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Spicy Dried Okra2 pounds okra1/4 cup olive oil1 tablespoon kosher salt2 teaspoons cayenne pepperScrub okra, rinse with cold water and pat dry with a towel.Halve okra lengthwise, cut into disks or leave whole and place okra in a large bowl.Drizzle olive oil over okra and toss..Add salt and cayenne pepper and toss to coat.Transfer okra to dehydrator.*Dry until crisp and breakable (about 12-18 hours, depending on dehydrator and okra size).Store in an airtight container.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/okra.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/okra.html</freezingUrl>

        <dryingUrl>https://www.hgtv.com/outdoors/gardens/garden-to-table/spicy-dried-okra#:~:text=Scrub%20okra%2C%20rinse%20with%20cold,okra%20in%20a%20large%20bowl.&text=Add%20salt%20and%20cayenne%20pepper%20and%20toss%20to%20coat.&text=Dry%20until%20crisp%20and%20breakable,on%20dehydrator%20and%20okra%20size).</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Onions</name>

        <image>onions</image>

        <canningMethod>IngredientsBrine Ingredients2 cups water1 cup vinegar1/3 cup sugar3 1/2 tbsp kosher saltPickle Ingredients2 lbs red onions1 3/4 tsp kosher salt1 1/2 tsp peppercorns3 bay leavesYou will also need: 3 pint-sized 3 piece mason jars, wide mouth funnel, canning pot, round rack that will fit into the bottom of your canning pot, jar lifter, small saucepan, magnetic lid lift (optional), tongs, a few clean kitchen towelsInstructions:Gluten Free Note: If you're making these pickles gluten free, make sure your vinegar is certified gluten free. If you can't find a GF white vinegar feel free to sub apple cider vinegar.To make brine: Combine water, vinegar, sugar and salt in a saucepot and simmer over low heat, stirring often, until the salt and sugar have dissolved. Set aside until ready to use.Trim the onions and slice into thin strips.Toss onions with 1 ¾ tsp kosher salt and allow to sit for about 30 minutes, then rinse.Evenly distribute the peppercorns and bay leaves between the pint jars.Add about 1/2 lb of sliced onions to each jar. Gently press down with tongs to make sure everything is loosely packed.Cover with brine, leaving about ½ inch of headspace. Make sure your brine is hot when you pour it over the onions.Let the jars return to room temperature, put the lids on, and store in the refrigerator for up to two weeks. The longer they sit the more they’ll pickle.</canningMethod>

        <freezingMethod>Bulb onions store well in a cool, dry place. Freezing is usually not recommended for preserving whole onions, but see below if desired.Diced Onions – Peel, trim and clean thoroughly. Dice (about 1/4-inch pieces). No blanching is required. Either pack dry into recommended freezer bags or containers, leaving1/2-inch headspace. Or, freeze separated pieces on a clean tray prior to packaging. Eliminate as much air as possible from the package for this method. Onions frozen this way are best used within a few months.Green Onions – Young green onions may be chopped for salads and cooking and frozen without blanching, but they will not be crisp. They will be highly flavored but may be slightly tough. They can be packaged by either of the methods above for diced onions.Whole Bulb Onions - Choose mature bulbs; peel, trim and clean thoroughly as for eating.Water blanch for 3 minutes (smaller onions) to 7 minutes (larger onions) or until center is completely heated.Cool promptly, drain well, and package, leaving 1/2-inch headspace. Seal and freeze. These would be considered suitable for cooking only.Onion Rings – Wash, peel and slice onions. Separate slices into rings. Water blanch for 10 to 15 seconds. Cool promptly, drain and coat with flour. Dip in milk. Coat with a mixture of equal parts cornmeal and pancake mix. Arrange in a single layer on a tray. Freeze. Pack into containers using plastic wrap to separate the layers. No headspace is necessary. Seal and freeze. To prepare, fry frozen rings in 375ºF oil until golden brown.</freezingMethod>

        <dryingMethod>Helpful equipment for dehydrating onions:Food dehydratorKnifeCutting boardSpice grinderMesh strainer to separate onion flakes from onion powderSpice jarsGloves (optional to protect your hands from the strong onion fragrance)Kitchen goggles (optional to shield your eyes)Steps for Making Dehydrated OnionsAny onion can be dehydrated, including red, white, and yellow. If you are cutting by hand, you may wish to wear gloves and eye protection to shield yourself from the pungent onion fragrance.Step 1: Prepare your onionsRemove the onion skins, trim the ends, and slice into even sized pieces. I like to cut the onions in half, and then slice each half into 1/4-inch pieces. Sometimes, I use my food processor’s slicing blade to speed up the process.The onions can be in any shape, as long as they are all about the same size, so they will dry evenly. You can cut the onions into rings, chunks, or whatever is easiest. Just try to keep the pieces large enough so they don’t fall through the screens of your dehydrator.Tip: Save the onion trimmings in the freezer for homemade chicken stock.Step 2: Spread the onions out on the dehydrating screensSeparate the onion segments and spread them out evenly on your dehydrator tray. The onion pieces can touch, but try not to overlap them, or they may not dehydrate evenly.Step 3: Dry your onionsDehydrate at 125˚F until completely dry, about 3 to 9 hours depending upon the size of your pieces and moisture content of your onions. It’s ok to stop the dehydrator and start it up again the next day. Follow the instructions for your dehydrator.Rotate your trays so the onions dry evenly. The dehydrated onions should be crisp and snap when your break them.Step 4: Package and store your dried onionsLet the onions cool after dehydrating, crush them into onion flakes with your hands or a mallet, and then package into airtight glass containers.Label, date, and store the jars of dried onion flakes in a dark, cool area. Check the jars in a few days to be sure there isn’t any moisture accumulating on the glass.I fill small jars for my spice cabinet, and then store the rest of the dehydrated onions in mason jars in my basement food storage area. Properly dehydrated onions will not spoil, but the flavor does diminish over time. </dryingMethod>

        <canningUrl>https://toriavey.com/toris-kitchen/pickled-red-onions/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/onion.html</freezingUrl>

        <dryingUrl>https://growagoodlife.com/dehydrate-onions/#:~:text=Turn%20your%20onions%20into%20dehydrated%20onion%20flakes,dried%20onions%2C%20and%20onion%20powder.&text=To%20dry%20the%20onions%3A,trays%20in%20a%20single%20layer.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Peas Blackeye or Field</name>

        <image>blackeye_or_field_peas</image>

        <canningMethod>Beans or Peas - Shelled, Dried: All VarietiesQuantity: An average of 5 pounds is needed per canner load of 7 quarts; an average of 3¼ pounds is needed per canner load of 9 pints--an average of ¾ pounds per quart.Quality: Select mature, dry seeds. Sort out and discard discolored seeds.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Place dried beans or peas in a large pot and cover with water. Soak 12 to 18 hours in a cool place. Drain water. To quickly hydrate beans, you may cover sorted and washed beans with boiling water in a saucepan. Boil 2 minutes, remove from heat, soak 1 hour and drain. Cover beans soaked by either method with fresh water and boil 30 minutes. Add ½ teaspoon of salt per pint or 1 teaspoon per quart to the jar, if desired. Fill jars with beans or peas and cooking water, leaving 1-inch headspace.Adjust lids and process as recommended in Table 1 or Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Select pods when seeds are tender and well-filled. Wash pods. Shell and discard over-mature and immature seeds and those injured by insects. Wash shelled peas.Water blanch 2 minutes. Cool promptly, drain and package, leaving 1/2 inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Prepping PeasBefore dehydrating, peas must be blanched in boiling water or steam to prevent enzymatic damage during storage. Before blanching, prepare an ice water bath to quickly cool the peas and stop the cooking process. Blanch snow peas in a steamer for 2 minutes, or for 1 minute in boiling water, and blanch sugar-snap peas in a steamer for 3 minutes or for 1 1/2 minutes in boiling water. Steam blanch shelled peas for 3 minutes or blanch them for 2 minutes in boiling water. Once the time is up, immediately immerse the peas in an ice bath until cool.Dehydrating PeasPlace the peas on screens or trays in the dehydrator or oven. Set the temperature to 125 degrees Fahrenheit, or the lowest setting your oven allows, and dehydrate for 5 to 13 hours until the peas crisp and become brittle. In a dehydrator, stir the peas around after about 2 hours to allow for even drying. In an oven, it is necessary to stir the peas several times during drying to prevent uneven drying.Doneness TestingShelling peas become wrinkly and hardened when completely dried. When firm pressure is applied to the peas, they should crumble. Sugar-snap and snow peas become brittle and darkened and take on a papery feel once completely dried. Sugar-snap peas become lumpy once dried, and you can confirm that they are done by cutting one pod open and checking that the peas inside the pod are dried.Rehydrating PeasTo use dehydrated peas, they must be soaked first to rehydrate. Hot soak dried shelled peas for 30 minutes to 1 hour, or cold soak them overnight. Add the rehydrated peas to soups and stews where they can be cooked further, or simmer them in their cooking water to eat as a plain vegetable. Snow peas can be added to soups and stews in their dehydrated state if they will be cooked for more than 30 minutes, and sugar-snap peas can be added if they will cook longer than 45 minutes. To eat on their own, rehydrate sugar-snap or snow peas by covering them with boiling water for 15 to 45 minutes, or until they are no longer hard.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/peas_green_shelled.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/peas_field.html</freezingUrl>

        <dryingUrl>https://oureverydaylife.com/how-to-dehydrate-peas-12788346.html#:~:text=Place%20the%20peas%20on%20screens,to%20allow%20for%20even%20drying.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Peas Green</name>

        <image>green_peas</image>

        <canningMethod>It is recommended that sugar snap and Chinese edible pods be frozen for best quality.Quantity: An average of 31-1/2 pounds (in pods) is needed per canner load of 7 quarts; an average of 20 pounds is needed per canner load of 9 pints. A bushel weighs 30 pounds and yields 5 to 10 quarts – an average of 4-1/2 pounds per quart.Quality: Select filled pods containing young, tender, sweet seeds. Discard diseased pods.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Shell and wash peas. Add 1 teaspoon of salt per quart to the jar, if desired.Hot pack – Cover with boiling water. Bring to a boil in a saucepan, and boil 2 minutes. Fill jars loosely with hot peas, and add cooking liquid, leaving 1-inch headspace.Raw pack – Fill jars with raw peas, add boiling water, leaving 1-inch headspace. Do not shake or press down peas.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Harvest when pods are filled with young, tender peas that have not become starchy. Wash and shell; water blanch l1/2 minutes, cool and drain. Package, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Prepping PeasBefore dehydrating, peas must be blanched in boiling water or steam to prevent enzymatic damage during storage. Before blanching, prepare an ice water bath to quickly cool the peas and stop the cooking process. Blanch snow peas in a steamer for 2 minutes, or for 1 minute in boiling water, and blanch sugar-snap peas in a steamer for 3 minutes or for 1 1/2 minutes in boiling water. Steam blanch shelled peas for 3 minutes or blanch them for 2 minutes in boiling water. Once the time is up, immediately immerse the peas in an ice bath until cool.Dehydrating PeasPlace the peas on screens or trays in the dehydrator or oven. Set the temperature to 125 degrees Fahrenheit, or the lowest setting your oven allows, and dehydrate for 5 to 13 hours until the peas crisp and become brittle. In a dehydrator, stir the peas around after about 2 hours to allow for even drying. In an oven, it is necessary to stir the peas several times during drying to prevent uneven drying.Doneness TestingShelling peas become wrinkly and hardened when completely dried. When firm pressure is applied to the peas, they should crumble. Sugar-snap and snow peas become brittle and darkened and take on a papery feel once completely dried. Sugar-snap peas become lumpy once dried, and you can confirm that they are done by cutting one pod open and checking that the peas inside the pod are dried.Rehydrating PeasTo use dehydrated peas, they must be soaked first to rehydrate. Hot soak dried shelled peas for 30 minutes to 1 hour, or cold soak them overnight. Add the rehydrated peas to soups and stews where they can be cooked further, or simmer them in their cooking water to eat as a plain vegetable. Snow peas can be added to soups and stews in their dehydrated state if they will be cooked for more than 30 minutes, and sugar-snap peas can be added if they will cook longer than 45 minutes. To eat on their own, rehydrate sugar-snap or snow peas by covering them with boiling water for 15 to 45 minutes, or until they are no longer hard.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/peas_green_shelled.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/peas_green.html</freezingUrl>

        <dryingUrl>https://oureverydaylife.com/how-to-dehydrate-peas-12788346.html#:~:text=Place%20the%20peas%20on%20screens,to%20allow%20for%20even%20drying.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Peas Pods Edible (Sugar, Chinese, Snow Peas or Sugar Snap Peas)</name>

        <image>peas_pods</image>

        <canningMethod>It is recommended that sugar snap and Chinese edible pods be frozen for best quality.Quantity: An average of 31-1/2 pounds (in pods) is needed per canner load of 7 quarts; an average of 20 pounds is needed per canner load of 9 pints. A bushel weighs 30 pounds and yields 5 to 10 quarts – an average of 4-1/2 pounds per quart.Quality: Select filled pods containing young, tender, sweet seeds. Discard diseased pods.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Shell and wash peas. Add 1 teaspoon of salt per quart to the jar, if desired.Hot pack – Cover with boiling water. Bring to a boil in a saucepan, and boil 2 minutes. Fill jars loosely with hot peas, and add cooking liquid, leaving 1-inch headspace.Raw pack – Fill jars with raw peas, add boiling water, leaving 1-inch headspace. Do not shake or press down peas.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Select bright green, flat, tender pods. Wash. Remove stems, blossom ends and any strings. Leave whole. Water blanch 11/2 minutes for small pods; 2 minutes for large pods. (NOTE: If the peas have started to develop, follow the directions for green beans. If the peas are already developed, shell and follow the directions for green peas.) Cool, drain and package, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Prepping PeasBefore dehydrating, peas must be blanched in boiling water or steam to prevent enzymatic damage during storage. Before blanching, prepare an ice water bath to quickly cool the peas and stop the cooking process. Blanch snow peas in a steamer for 2 minutes, or for 1 minute in boiling water, and blanch sugar-snap peas in a steamer for 3 minutes or for 1 1/2 minutes in boiling water. Steam blanch shelled peas for 3 minutes or blanch them for 2 minutes in boiling water. Once the time is up, immediately immerse the peas in an ice bath until cool.Dehydrating PeasPlace the peas on screens or trays in the dehydrator or oven. Set the temperature to 125 degrees Fahrenheit, or the lowest setting your oven allows, and dehydrate for 5 to 13 hours until the peas crisp and become brittle. In a dehydrator, stir the peas around after about 2 hours to allow for even drying. In an oven, it is necessary to stir the peas several times during drying to prevent uneven drying.Doneness TestingShelling peas become wrinkly and hardened when completely dried. When firm pressure is applied to the peas, they should crumble. Sugar-snap and snow peas become brittle and darkened and take on a papery feel once completely dried. Sugar-snap peas become lumpy once dried, and you can confirm that they are done by cutting one pod open and checking that the peas inside the pod are dried.Rehydrating PeasTo use dehydrated peas, they must be soaked first to rehydrate. Hot soak dried shelled peas for 30 minutes to 1 hour, or cold soak them overnight. Add the rehydrated peas to soups and stews where they can be cooked further, or simmer them in their cooking water to eat as a plain vegetable. Snow peas can be added to soups and stews in their dehydrated state if they will be cooked for more than 30 minutes, and sugar-snap peas can be added if they will cook longer than 45 minutes. To eat on their own, rehydrate sugar-snap or snow peas by covering them with boiling water for 15 to 45 minutes, or until they are no longer hard.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/peas_green_shelled.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pea_pod.html</freezingUrl>

        <dryingUrl>https://oureverydaylife.com/how-to-dehydrate-peas-12788346.html#:~:text=Place%20the%20peas%20on%20screens,to%20allow%20for%20even%20drying.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Peppers Bell or Sweet</name>

        <image>bell_or_sweet_peppers</image>

        <canningMethod>Hot or sweet, including chiles, jalapeno, and pimientoQuantity: An average of 9 pounds is needed per canner load of 9 pints. A bushel weighs 25 pounds and yields 20 to 30 pints – an average of 1 pound per pint.Quality: Select firm yellow, green, or red peppers. Do not use soft or diseased peppers.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure:Caution: Wear plastic or rubber gloves and do not touch your face while handling or cutting hot peppers. If you do not wear gloves, wash hands thoroughly with soap and water before touching your face or eyes.Select your favorite pepper(s). Small peppers may be left whole. Large peppers may be quartered. Remove cores and seeds. Slash two or four slits in each pepper, and either blanch in boiling water or blister using one of the following methods:Oven or broiler method: Place peppers in a hot oven (400° F) or broiler for 6-8 minutes until skins blister.Range-top method: Cover hot burner, either gas or electric, with heavy wire mesh. Place peppers on burner for several minutes until skins blister.Allow peppers to cool. Place in a pan and cover with a damp cloth. This will make peeling the peppers easier. After several minutes, peel each pepper. Flatten whole peppers. Add 1/2 teaspoon of salt to each pint jar, if desired. Fill jars loosely with peppers and add fresh boiled water, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Select crisp, tender, green or bright red pods. Wash, cut out stems, cut in half and remove seeds. If desired, cut into 1/2-inch strips or rings.Heated – Good for use in cooking. Water blanch halves 3 minutes, strips or rings 2 minutes. Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze.Unheated – Good for use in uncooked foods because they have a crisper texture, or in cooked foods. Package raw, leaving no headspace. Seal and freeze.</freezingMethod>

        <dryingMethod> Finely diced, medium 1/2″ or smaller dice, matchsticks, and my favorite size 3/4″-1″ pieces. The smaller pieces were completely dry overnight, approximately 9 hours at 125 degrees. The larger ones took another couple of hours to completely dry out.I poured the dehydrated pepper pieces into jars and was amazed once again by how much smaller everything is now. The tiny jar on the top right contains three peppers worth of finely diced pieces.I was anxious to see how they would rehydrate, so I used some of them in our dinner tonight. This is one tablespoon of finely diced and then dried bell peppers. I poured boiling water over the pieces and then let them soak in that for about 20 minutes.Once the pieces were soft, I drained the water and this was the result. Perfectly rehydrated pieces of bell pepper. I tasted one of them and it was perfect. The flavor was the same, the texture was softer of course, but they worked great with our dinner.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/peppers.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pepper_bell.html</freezingUrl>

        <dryingUrl>https://barefeetinthekitchen.com/dehydrated-bell-peppers/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Peppers Hot</name>

        <image>hot_peppers</image>

        <canningMethod>Hot or sweet, including chiles, jalapeno, and pimientoQuantity: An average of 9 pounds is needed per canner load of 9 pints. A bushel weighs 25 pounds and yields 20 to 30 pints – an average of 1 pound per pint.Quality: Select firm yellow, green, or red peppers. Do not use soft or diseased peppers.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure:Caution: Wear plastic or rubber gloves and do not touch your face while handling or cutting hot peppers. If you do not wear gloves, wash hands thoroughly with soap and water before touching your face or eyes.Select your favorite pepper(s). Small peppers may be left whole. Large peppers may be quartered. Remove cores and seeds. Slash two or four slits in each pepper, and either blanch in boiling water or blister using one of the following methods:Oven or broiler method: Place peppers in a hot oven (400° F) or broiler for 6-8 minutes until skins blister.Range-top method: Cover hot burner, either gas or electric, with heavy wire mesh. Place peppers on burner for several minutes until skins blister.Allow peppers to cool. Place in a pan and cover with a damp cloth. This will make peeling the peppers easier. After several minutes, peel each pepper. Flatten whole peppers. Add 1/2 teaspoon of salt to each pint jar, if desired. Fill jars loosely with peppers and add fresh boiled water, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the method of canning used.</canningMethod>

        <freezingMethod>Preparation – Wash and stem peppers. Package, leaving no headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Dry peppers can last from several months to a few years if stored properly. Just note that thinner skinned peppers are better for drying. Below I offer several ways you can dry your peppers along with ideas of what do to with them once dried.Before drying your peppers, always wash them with warm water and dry thoroughly with a towel.DRYING HOT PEPPERS INDOORSThis is my preferred method just because it’s simple and I grow a lot of small, thin-skinned red peppers like Pequin, Tabasco, Thai Peppers and Firecracker Cayennes. The photo above is from the latest harvest from some of those plants. I dried and then coarsely blended these into some REALLY hot red pepper flakes. 🔥 If you’re not really in a big hurry for your dried peppers, just place whole or sliced chile peppers, single-layer, on a plate or baking sheet and set them in a very dry, warm area with loads of sunlight. Under a window should work best. If your peppers are a little larger, place them on a cooling rack while drying so they have air circulation all around. These peppers can also be moved outside to bask in the sun for a bit on hot and sunny days.I only dry small peppers with thin flesh, and I cover mine with a paper towel just so they don’t get dusty. If drying larger peppers, I cut off the stems to expose the inside to allow the pepper to dry out more quickly.Thicker skinned peppers (like Jalapeños) have a greater chance of rotting before drying out. For these types of peppers, you can slice them in half. Be sure to rotate the peppers regularly and discard any that show signs of softness or spoilage. Within a week or two, your peppers should get dry and brittle.DRYING PEPPERS OUTDOORSSimilar to drying indoors, place whole or sliced chile peppers single-layer on a plate or baking sheet and set them outside when you have consistent hot and sunny days. Make sure they are in an area that gets lots of sunlight. If you’ve sliced the peppers, you can place a screen over the sheet or plate to keep out insects.You can also make a strand of peppers by hanging them from a string. Start with whole peppers with stems still on. Thin-skinned peppers work best. Take a long needle and, using a strong thread or fishing line, string them together through the stems. Keep about an inch or so between each pepper for airflow. Tie a toothpick or small stick on each end to keep the peppers from sliding off. Hang them horizonally in an area that receives lots of sunlight and fresh air.DRYING PEPPERS IN THE OVENFor a quicker method, you can dry your peppers in the oven. The peppers may take several hours to fully dry, depending on the size. Larger, thicker-skinned peppers will take longer to dry than smaller or thin-skinned chiles. Cut your peppers in half or quarters so the flesh is open and dries out faster. Place the peppers seed side up on a parchment-lined cookie sheet in a single layer. Bake at 125 degrees F (or your lowest setting) for several hours. To allow moisture to escape, keep the oven door slightly open at least a couple of inches. Every hour, rotate and/or flip the peppers over for even drying. Keep a very close eye on them and remove those that are well dried. Also do your best to keep thee peppers from burning. If you find peppers getting soft, brown-to-black, or extremely hot on the side where they touch the pan, then they’re getting cooked. and you’re trying to avoid this.DRYING PEPPERS IN A FOOD DEHYDRATORThis is the quickest and easiest way to dry hot chile peppers if you have a food dehydrator. If your peppers are medium or large in size cut them length-wise and place them on the dehydrator’s tray with plenty of space around each piece for good airflow. Smaller peppers (1 inch or less in length) can be left whole to dry.If your dehydrator has a temperature setting, place it between 135 and 145 degrees. Let the chiles lay in the dehydrator for 8 to 12 hours, checking every so often to see if the smaller or thinner pieces have dried out. Larger pepper pieces may take a few additional hours to dehydrate. The peppers are done once they dry and become brittle.I HAVE DRIED THE PEPPERS– NOW WHAT?There are many uses for your dried peppers!Finely grind any dried hot pepper into a powder using a food processor, blender, coffee grinder, or spice mill.Coarsely grind dried red peppers into red pepper flakes. So much hotter and more flavorful than store bought pepper flakes!Store them in a Ziplock bag. You can rehydrate peppers or used them dried in any recipe.Create your own spice blend to give to family and friends as gifts so that they can spice up their own recipes!</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/peppers.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pepper_hot.html</freezingUrl>

        <dryingUrl>https://www.cayennediane.com/how-to-dry-peppers/#:~:text=Cut%20your%20peppers%20in%20half,least%20a%20couple%20of%20inches.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Pimientos</name>

        <image>pimientos</image>

        <canningMethod>INGREDIENTS1 pound/ 500 g hot peppers14 oz or 400 ml white wine vinegar or cider apple vinegar 5%sterilized jars and lidsINSTRUCTIONSClean the jars.The jars need to be sterilized by boiling them for 10 minutes in a pot of water on the stove.Wash and clean the hot peppers. Remove leaves, dirt and any bad peppers.When the sterilizing time is up, remove and drain hot sterilized jars one at a time.Fill the jars with peppers, as many as they fit tight inside and pour vinegar over them to fill up the jars. Add lids, and tighten screw bands.Great with soups or as a condiment in stews. They last in a cool place for years.The peppers need to sit in vinegar for at least one month before they are ready to be consumed.</canningMethod>

        <freezingMethod>Preparation – Select firm, crisp pimientos of deep red color. Peel by roasting in oven 400 to 450ºF for 6 to 8 minutes or until skins can be rubbed off. Wash off the charred skins, cut out stems and remove seeds. Package, leaving 1/2-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>INGREDIENTS10-15 chili peppers, you actually need full plants, not just peppers10-15 red bell peppers, you actually need full plants, not just pepperDIRECTIONSPaprika is made from the Capsicum Pepper. Depending on how mild you want your paprika, you can make your paprika from chili peppers, which are spicier, or from red bell peppers, which are milder.Plant 10 to 15 chili or red bell pepper plants. This is the number of plants that you need in order to make your paprika. (If you want to do other things with chili and bell peppers, such as stuffing, canning, or eating, you will need to plant more of them.)OPTION #1: Dry the red peppers by stringing them and hanging them in a dry place. (It takes about a year.)OPTION #2: Dry the red peppers in a food dehydrator.OPTION #3: Put the peppers in your smoker and use oak wood to smoke your red peppers dry. (This will give them a smokey flavor -- "smoked paprika". I'm not sure how long it will take to dry them by this method.).The peppers must be totally dry!Once the peppers are totally dry, dispose of the stems and save the seeds for next year's planting.Break the peppers into small enough pieces that they will fit in your spice or coffee grinder. (If you're using chili peppers, you can grind the seeds in with the peppers to make the paprika spicier.).Put the peppers (and seeds if desired) into the spice or coffee grinder. Set the grinder to the "fine" setting, if applicable, and grind the peppers into a powder.Some of the peppers will take longer to grind. Just make sure that you sift through the paprika to make sure that it is all powder.Finally, store your paprika in an air-tight jar using your food saver. It should last until the next year's harvest.</dryingMethod>

        <canningUrl>https://www.thebossykitchen.com/how-to-preserve-hot-peppers-in-vinegar/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pimento.html</freezingUrl>

        <dryingUrl>https://www.food.com/recipe/homemade-paprika-494183</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Potatoes New Irish</name>

        <image>new_irish_potatoes</image>

        <canningMethod>INGREDIENTSPotatoes (see notes for quantity)Canning Salt (optional ~ 1 tsp per quart, see note)INSTRUCTIONSPlace two large pots of water on the stove and bring them to a boil. One is to pre-cook the potatoes, and the other is fresh, clean water that will be used as canning liquid in the jars. Important: Do not re-use cooking liquid from the potatoes for packing.While the water is coming to a boil, prepare your potatoes. Peel the potatoes, and chop any large spuds into 1 to 2'' pieces. Smaller potatoes under 2'' in diameter can be left whole, but still must be peeled. Place the potatoes in a bowl of water and keep them submerged to prevent browning while you work.Once the water is boiling, place the potatoes into the water and pre-cook for 2 minutes (for 1'' cubes) or 10 minutes (for whole potatoes about 2'' in diameter). Strain the potatoes after cooking and discard the cooking liquid.Pack the cooked potatoes into canning jars (pints or quarts, quarts recommended for efficiency). Leave 1'' headspace.Cover with clean, boiling water and add 1 tsp salt per quart (optional).Wipe rims and apply 2 part canning lids, tightening to just finger tight.Place your pressure canner on the stove and add about 2'' of boiling water to the bottom from the clean boiling water pot. Insert the canning rack that came with the canner, and then load in the hot jars into the pressure canner.Close the pressure canner and allow the steam to vent for 10 minutes before fully sealing with a canning weight.Allow the pressure canner to come up to pressure, and begin timing once the required pressure is shown on the gauge. When canning potatoes under 1000 feet in elevation, set the pressure canner to 10 pounds pressure and process for 35 minutes (pints) or 40 minutes (quarts). For other altitudes and when using a dial gauge pressure canner, see the table above for the appropriate times/pressures for canning potatoes.NOTESThe yield will vary based on the size of your potatoes and how efficient you are with peeling, as well as how efficient you are at packing the jars. Potatoes in a small dice mean more pounds per jar, while whole 2'' potatoes mean less pounds per jar. For diced potatoes, it takes just under 3 pounds to fill a quart jar, and for small whole potatoes, it's more like 2 pounds per jar.My 30 quart All American pressure canner holds 14 quarts, while many smaller models hold 7. Adjust the total quantity of potatoes to your batch size and cutting methods. If you'd like to check ahead of time, pack the jars with raw potatoes to measure, knowing that they'll shrink a bit in the blanching, so be sure to have a bit extra too.Do not use iodized table salt for canning, it contains other anti-caking agents. Only use canning salt or kosher salt. The salt is optional in this recipe, and not necessary for preservation. It is recommended for flavor, and maintaining the texture of the potatoes during canning.</canningMethod>

        <freezingMethod>Preparation – Select smooth new potatoes directly from the garden. Peel or scrape and wash. Water blanch for 3 to 5 minutes, depending on the size.Cool, drain and package whole or sectioned, leaving 1/2-inch headspace. Seal and freeze.French Fried Potatoes – Select mature potatoes which have been stored 30 days. Wash, peel and cut into 1/3-inch sticks lengthwise, then crosswise into 3/8-inch strips. Rinse in cold water. Dry thoroughly. Fry small amounts in deep, hot fat (360ºF) about 5 minutes until tender but not brown. Drain on paper towel. Cool. Package, seal and freeze.At serving time, finish browning in a hot oven (475ºF). </freezingMethod>

        <dryingMethod>HOW TO DEHYDRATE POTATOESStep 1Wash potatoes and cut out any blemishes. Whether or not you peel potatoes is totally up to you. Sometimes I do, sometimes I don’t as you’ll see in the various photos.Step 2Slice potatoes to about 1/8 inch or 2.5 mm thick. I used the food processor, but a mandolin or sharp knife also work. Just try to keep the thickness consistent.If you want, you can also make shredded dehydrated potatoes. Use the coarse shredding side of your grater.Step 3Whether you shred or slice potatoes, place them in a bowl of water right away to prevent oxidation. Potatoes will start to turn brown very quickly! It only took about 60 to 90 seconds for these potato slices to turn brown.STEP 4BLANCH POTATOES BEFORE DEHYDRATING – SUPER IMPORTANT!!Blanch the potatoes by bringing a large pot of water to boil. Add potato slices or shredded potatoes to the water and resume boiling until slices are fork tender, about 4-6 minutes. Fork tender means you can insert a fork easily without the potato crumbling.Do NOT skip this step. Seriously, the results are not pretty. Potatoes that are not blanched will turn a very unappealing grey to black colour as they dehydrate. They are not dangerous to eat – but no one will want to eat them.Did I mention you need to blanch your potatoes before dehydrating?!Step 5Strain potatoes or scoop out with a big slotted spoon.Step 6Lay slices out on dehydrator screen so they are not overlapping.Shredded potatoes can overlap.Step 7Place in dehydrator and dry at 135° F/60° C for 8 to 10 hours. If you do a mix of shredded and sliced, be aware that the shreds may take a little less time than the slices and you may need to rotate trays or remove some before the others are completely dry.Potatoes will be translucent and crisp throughout – just like the potatoes in a box of scalloped potatoes.Unless of course, you leave the peel, then they look like homemade goodness and no boxed product could compare.Step 8Allow to cool and store in a large container where they will not be crushed.HOW TO USE DEHYDRATED POTATOESFor hashbrowns, soak the shredded potatoes in water for 15 minutes, drain and pan fry.For dried potato slices, either use them dry in casseroles, potato au gratin or scalloped potato recipes. You can also pan fry them after re-hydrating them by soaking in water for 15 minutes or so. </dryingMethod>

        <canningUrl>https://practicalselfreliance.com/canning-potatoes/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/potato_new.html</freezingUrl>

        <dryingUrl>https://www.gettystewart.com/dehydrating-potatoes/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Potatoes Sweet</name>

        <image>sweet_potatoes</image>

        <canningMethod>Potatoes, Sweet - Pieces or WholeIt is not recommended to dry pack sweet potatoes.Quantity: An average of 17-1/2 pounds is needed per canner load of 7 quarts; an average of 11 pounds is needed per canner load of 9 pints. A bushel weighs 50 pounds and yields 17 to 25 quarts – an average of 2- 1/2 pounds per quart.Quality: Choose small to medium-sized potatoes. They should be mature and not too fibrous. Can within 1 to 2 months after harvest.Please read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash potatoes and boil or steam until partially soft (15 to 20 minutes). Remove skins. Cut medium potatoes, if needed, so that pieces are uniform in size. Caution: Do not mash or puree pieces. Fill jars, leaving 1-inch headspace. Add 1 teaspoon salt per quart to the jar, if desired. Cover with your choice of fresh boiling water or syrup, leaving 1-inch headspace.Adjust lids and process following the recommendations in Table 1 and Table 2.</canningMethod>

        <freezingMethod>Preparation – Choose medium to large sweet potatoes that have been cured for at least one week. Sort according to size and wash. Cook until almost tender in water, in steam, in a pressure cooker or in the oven. Let stand at room temperature until cool. Peel sweet potatoes, cut in halves, slice or mash.If desired, to prevent darkening, dip whole sweet potatoes or slices for 5 seconds in a solution of 1/2 cup lemon juice to 1 quart water.To keep mashed sweet potatoes from darkening, mix 2 tablespoons orange or lemon juice with each quart of mashed sweet potatoes.Pack into containers, leaving 1/2-inch headspace. Seal and freeze.Baked – Wash, trim and heat potatoes in oven at 350ºF without peeling until slightly soft. Cool, remove peel and wrap individually in aluminum foil. Place in polyethylene bags and freeze. Complete the baking in an oven at 350ºF immediately before serving, leaving the potatoes wrapped in foil. </freezingMethod>

        <dryingMethod>Sweet Potato Dog ChewsIngredients3 sweet potatoesInstructionsPreheat oven 200 degrees and line a baking sheet with parchment paper.Slice the ends off sweet potatoes to make for easier slicing. Cut 1/3-inch lengthwise slices using a sharp knife or mandolin.Bake for 6 hours, flipping once during the cooking time. After 6 hours, turn off your oven and leave the chews in the oven as it cools.Store sweet potato chews in a sealed container for up to 2 weeks.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/potato_sweet.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/potato_sweet.html</freezingUrl>

        <dryingUrl>https://www.platingsandpairings.com/sweet-potato-dog-chews-7/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Pumpkin</name>

        <image>pumpkin</image>

        <canningMethod>The Rules of Canning Pumpkin1) If you are going to can pumpkin, you must, must, must use a pressure canner--no exceptions. I know, pressure canning seems scarier than water bath canning, but it’s absolutely vital since pumpkin is a low-acid food. And if you follow my pressure canning tutorial, it’s easy peasy. (No explosions, either.)2) It’s a bummer, but you cannot can pumpkin puree–you can only can pumpkin cubes (Holy wow… there’s a lot of “cans” in that sentence). According to the National Center for Home Food Preservation, “We have no properly researched directions to recommend for canning mashed or pureed pumpkin or winter squash, or pumpkin butter.” So yeah, that’s one area where I don’t live on the edge. The same goes for canning refried beans, which is why I just can whole beans and then mash ’em after I open the jars.So do you promise you’ll follow the rules? Okay, then I’ll share the recipe. 🙂 Canning Pumpkin the Easy WayYou will need:Pie pumpkinsWaterA pressure cannerJarsPressure Canning Tutorial: https://www.theprairiehomestead.com/2012/08/how-to-use-a-pressure-canner-part-1.htmlFirst Objective: We need to cut the pumpkins into cubes. This is the “hardest” part of this whole process, mainly because you can’t use my quick tip for making pumpkin puree (because we need the pumpkin to remain raw and not get too soft). But never fear–it’s still do-able. Here’s how I did it:Cut the stem out like you are getting ready to carve a jack-o-lantern.Cut the pumpkin into four or five wedges.Use a spoon to scrape out the pumpkin guts.Peel the pumpkin. I was very thankful my vegetable peeler worked for this. However, if you are dealing with pumpkins with a super-hard rind, you might need a sharp knife to remove the peel instead. Watch those fingers!Cut the peeled pumpkin into (roughly) 1-inch cubes.Place the cubes in a large pot and cover with water.Boil for 2 minutes, then place the pumpkin cubes into hot jars. (Avoid smashing down the cubes as much as possible!)Cover the pumpkin cubes with the leftover hot cooking liquid, leaving 1-inch of headspace.Add lids and rings and place into your pressure canner. Process quart jars for 90 minutes at 15 pounds pressure. Process pint jars for 55 minutes at 15 pounds pressure.When you are ready to make pumpkin puree, simply open a jar, strain out the liquid, and mash! I found one jar of drained, mashed pumpkin gave me around 2-3 cups of puree.</canningMethod>

        <freezingMethod>Preparation – Select full-colored mature pumpkin with fine texture. Wash, cut into cooking-size sections and remove seeds.Cook until soft in boiling water, in steam, in a pressure cooker or in an oven. Remove pulp from rind and mash. To cool, place pan containing pumpkin in cold water and stir occasionally. Package, leaving ½-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>Cooking The Fresh PumpkinI started off by cutting the pumpkin in half and scooping out the seeds and membranes. Since these sugar-pie pumpkins are heirloom I typically save some of the seeds my garden.After the pumpkins are cut & cleaned out it’s time to cook it up. Oftentimes if the sun is out I’ll use my Solar Oven to Cook The Pumpkin. But obviously you can use a regular oven as well.If I’m cooking it inside I retrieve my large, vintage covered roaster. The two pumpkin halves are placed cut-side down in the roaster and I add a cup or two of water. This will steam the pumpkin to cook it.The roaster’s lid is placed on top & I put it into the oven. The temp is set to 350 degrees Fahrenheit and I set my timer for 30 minutes. When the time is up I turn the oven off & let the pumpkin stay in the hot oven soak up the residual heat until it’s cool to finish cooking. (but you can just cook for 45 minutes or so if you’re in a hurry)Creating Pumpkin PureeWhen it’s cool I pull the roaster from the oven & scrape the pumpkin meat from the shell. You can use a heavy spoon but I love to use a large ice cream scoop. It’s heavy & there’s no fear in bending it if I get a little carried away scooping.Dehydrating Pumpkin PureeNow I plop about 2 cups onto each *Paraflex Sheet for my Excalibur Dehydrator and spread it all smoothly. You’re basically treating this puree the same as you would for Fruit Rollups.When all the puree has been smoothed onto trays I put them all into my *Excalibur Dehydrator and set the temp to 125 degrees. The pumpkin needs to dehydrate for about 12-14 hours. So for convenience sake, if I’ve cooked the pumpkin during the day & pureed it at night I can turn the dehydrator on when I go to bed and let it do it’s thing all night. That’s a lot of hands-off time and I’m lazy, errrr I mean efficient that way!In the morning I peel the sheets of dried puree and flip it over to make sure it dries properly on the underside too. Then I let it dehydrate for a few hours more. All in all about 12 hours for me, but your dehydrator and even the relative humidity in your home could make your time slightly different. You’re looking to dry the puree until it’s crisp enough to break up.But for me it’s about 12 hours in the dehydrator until the puree is completely dry & brittle.Powdering Dehydrated PumpkinI break up the pieces and drop them into a *coffee grinder I reserve for just this task. A couple of pulses will grind the chunks until they’re once again perfectly powdered – no lumps!Now that it’s dehydrated and powdered that whole pumpkin doesn’t even fill up a tiny 1/2-pint canning jar!When it’s time to rehydrate my pumpkin powder for puree use I’ll simply boil some water (4:1 ratio water to pumpkin) and stir in some pumpkin powder and let it cool about 15-20 minutes. BOOM! Pumpkin puree!It’s a no-waste way to make sure that delightful pumpkin harvest is fully used.</dryingMethod>

        <canningUrl>https://www.theprairiehomestead.com/2014/10/how-to-can-pumpkin.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pumpkin.html</freezingUrl>

        <dryingUrl>https://texashomesteader.com/dehydrate-pumpkin/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Rhubarb</name>

        <image>rhubarb</image>

        <canningMethod>Quantity: An average of 10-1/2 pounds is needed per canner load of 7 quarts; an average of 7 pounds is needed per canner load of 9 pints. A lug weighs 28 pounds and yields 14 to 28 quarts – an average of 1-1/2 pounds per quart.Quality: Select young, tender, well-colored stalks from the spring or late fall crop.Please read Using Pressure Canners and Using Boiling Water Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Trim off leaves. Wash stalks and cut into 1/2-inch to 1-inch pieces. In a large saucepan add 1/2 cup sugar for each quart of fruit. Let stand until juice appears. Heat gently to boiling. Fill jars without delay, leaving 1/2-inch headspace. Adjust lids and process.Process directions for canning rhubarb in a boiling-water, a dial, or a weighted-gauge canner are given in Table 1, Table 2, and Table 3.</canningMethod>

        <freezingMethod>Preparation – Choose firm, tender, well-colored stalks with good flavor and few fibers. Wash, trim and cut into lengths to fit the package. Heating rhubarb in boiling water for 1 minute and cooling promptly in cold water helps retain color and flavor.Dry Pack – Pack either raw or preheated rhubarb tightly into containers without sugar. Leave headspace. Seal and freeze.Syrup Pack – Pack either raw or preheated rhubarb tightly into containers, cover with cold 40 percent syrup. Leave headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>1. Pick and wash rhubarb stalks. Choose fresh, good quality rhubarb stalks that aren’t woody.2. Chop rhubarb into even, 1/4 to 1/2 inch pieces (1 to 2 cm).3. Spread in a single layer on mesh dehydrator trays.4. Dry at 135°F (57°C) for 8 to 12 hours depending on your dehydrator, rhubarb and humidity levels.5. Rhubarb will feel dry and crisp with no moisture inside when broken open. Err on the side of over-drying if in doubt.6. Turn dehydrator off and let rhubarb sit overnight before storing in a well sealed container in a dark, dry space for up to 1 year. Dried rhubarb will be safe to eat beyond one year, but the color will change over time. To preserve color for longer, blanch rhubarb for 2 minutes before drying. </dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/rhubarb_stewed.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/rhubarb.html</freezingUrl>

        <dryingUrl>https://www.gettystewart.com/how_to_dehydrate_rhubarb/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Rutabagas</name>

        <image>rutabagas</image>

        <canningMethod>https://www.healthycanning.com/canning-rutabaga/</canningMethod>

        <freezingMethod>Preparation – Select young, medium-sized rutabagas. Cut off tops, wash and peel. Cubed – Cut into cubes and water blanch 3 minutes.Cool, drain and pack, leaving 1/2-inch headspace. Seal and freeze.Mashed – Cut into chunks and cook until tender in boiling water. Drain, mash, cool and pack into containers, leaving headspace. Seal and freeze. </freezingMethod>

        <dryingMethod>https://countrifiedhicks.blogspot.com/2016/11/dehydrating-rutabagas.html#:~:text=To%20dehydrate%20a%20rutabaga%2C%20rinse%20them%20well%20and%20then%20peel%20them.&text=Using%20a%20mandolin%20or%20sharp,about%201%2F8%22%20thick.&text=Turn%20on%20your%20dehydrator%20to,are%20ready%20the%20next%20morning.</dryingMethod>

        <canningUrl>https://www.healthycanning.com/canning-rutabaga/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/rutabaga.html</freezingUrl>

        <dryingUrl>https://countrifiedhicks.blogspot.com/2016/11/dehydrating-rutabagas.html#:~:text=To%20dehydrate%20a%20rutabaga%2C%20rinse%20them%20well%20and%20then%20peel%20them.&text=Using%20a%20mandolin%20or%20sharp,about%201%2F8%22%20thick.&text=Turn%20on%20your%20dehydrator%20to,are%20ready%20the%20next%20morning.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Squash Summer(Cocozelle, Crookneck, Pattypan, Straightneck, White Scallop, Zucchini)</name>

        <image>summer_squash</image>

        <canningMethod>https://nchfp.uga.edu/how/can_04/pumpkin_winter_squash.html</canningMethod>

        <freezingMethod>Preparation – Choose young squash with tender skin. Wash and cut in 1/2-inch slices. Water blanch 3 minutes. Cool promptly, drain and package, leaving 1/2-inch headspace. Seal and freeze.Grated Zucchini (for Baking) – Choose young tender zucchini. Wash and grate. Steam blanch in small quantities 1 to 2 minutes until translucent. Pack in measured amounts into containers, leaving 1/2-inch headspace. Cool by placing the containers in cold water. Seal and freeze.If watery when thawed, discard the liquid before using the zucchini.</freezingMethod>

        <dryingMethod>https://www.thespruceeats.com/dehydrate-zucchini-and-summer-squash-1327567#:~:text=Set%20the%20dehydrator%20for%20135,transfer%20it%20to%20airtight%20containers.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/pumpkin_winter_squash.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/squash_summer.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/dehydrate-zucchini-and-summer-squash-1327567#:~:text=Set%20the%20dehydrator%20for%20135,transfer%20it%20to%20airtight%20containers.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Squash Winter(Acorn, Banana, Buttercup, Butternut, Golden Delicious, Hubbard, Spaghetti)</name>

        <image>winter_squash</image>

        <canningMethod>https://nchfp.uga.edu/how/can_04/pumpkin_winter_squash.html</canningMethod>

        <freezingMethod>Preparation – Select firm, mature squash with a hard rind. For spaghetti squash, mashing the cooked pulp is not necessary.Cook until soft in boiling water, in steam, in a pressure cooker or in an oven. Remove pulp from rind and mash. To cool, place pan containing winter squash in cold water and stir occasionally. Package, leaving ½-inch headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>https://www.thespruceeats.com/dehydrate-zucchini-and-summer-squash-1327567#:~:text=Set%20the%20dehydrator%20for%20135,transfer%20it%20to%20airtight%20containers.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/pumpkin_winter_squash.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/squash_winter.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/dehydrate-zucchini-and-summer-squash-1327567#:~:text=Set%20the%20dehydrator%20for%20135,transfer%20it%20to%20airtight%20containers.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Tomatoes</name>

        <image>tomatoes</image>

        <canningMethod>https://food52.com/recipes/347-grandma-s-canned-tomatoes</canningMethod>

        <freezingMethod>Preparation – Select firm, ripe tomatoes with deep red color.Raw – Wash and dip in boiling water for 30 seconds to loosen skins. Core and peel. Freeze whole or in pieces. Pack into containers, leaving l-inch headspace. Seal and freeze. Use only for cooking or seasoning as tomatoes will not be solid when thawed.Juice – Wash, sort and trim firm, vine-ripened tomatoes. Cut in quarters or eighths. Simmer 5 to 10 minutes. Press through a sieve. If desired, season with 1 teaspoon salt to each quart of juice. Pour into containers, leaving headspace. Seal and freeze.Stewed – Remove stem ends, peel and quarter ripe tomatoes. Cover and cook until tender (10 to 20 minutes). Place pan containing tomatoes in cold water to cool. Pack into containers, leaving headspace. Seal and freeze. </freezingMethod>

        <dryingMethod>https://www.wholesomeyum.com/how-to-make-sun-dried-tomatoes-in-the-oven/</dryingMethod>

        <canningUrl>https://food52.com/recipes/347-grandma-s-canned-tomatoes</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/tomato.html</freezingUrl>

        <dryingUrl>https://www.wholesomeyum.com/how-to-make-sun-dried-tomatoes-in-the-oven/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Tomatoes Green</name>

        <image>green_tomatoes</image>

        <canningMethod>https://food52.com/recipes/347-grandma-s-canned-tomatoes</canningMethod>

        <freezingMethod>Preparation – Select firm, sound green tomatoes. Wash, core, and slice 1/4-inch thick.For Frying – Pack the slices into containers with freezer wrap between the slices. Leave 1/2-inch headspace. Seal and freeze. </freezingMethod>

        <dryingMethod>https://www.wholesomeyum.com/how-to-make-sun-dried-tomatoes-in-the-oven/</dryingMethod>

        <canningUrl>https://food52.com/recipes/347-grandma-s-canned-tomatoes</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/tomato_green.html</freezingUrl>

        <dryingUrl>https://www.wholesomeyum.com/how-to-make-sun-dried-tomatoes-in-the-oven/</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Turnips or Parsnips</name>

        <image>turnips_or_parsnips</image>

        <canningMethod>https://nchfp.uga.edu/how/can_04/spinach_greens.html</canningMethod>

        <freezingMethod>Preparation – Select small to medium, firm turnips or parsnips that are tender and have a mild flavor. Wash, peel and cut into 1/2-inch cubes. Water blanch for 2 minutes. Cool promptly in cold water and drain. Pack into containers, leaving 1/2-inch headspace. Seal and freeze, </freezingMethod>

        <dryingMethod>https://www.thespruceeats.com/drying-turnips-in-a-dehydrator-1327548#:~:text=Once%20the%20turnips%20are%20cool,at%20150%20F%2F65%20C.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/spinach_greens.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/turnip.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/drying-turnips-in-a-dehydrator-1327548#:~:text=Once%20the%20turnips%20are%20cool,at%20150%20F%2F65%20C.</dryingUrl>

        <type>vegetable</type>

        </Food>


        -<Food>

        <name>Zucchini</name>

        <image>zucchini</image>

        <canningMethod>https://nchfp.uga.edu/how/can_04/mixed_vegetables.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/squash_summer.html</freezingMethod>

        <dryingMethod>https://www.christinascucina.com/dried-zucchini-save-some-for-winter/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_04/mixed_vegetables.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/squash_summer.html</freezingUrl>

        <dryingUrl>https://www.christinascucina.com/dried-zucchini-save-some-for-winter/</dryingUrl>

        <type>vegetable</type>

        </Food>

        </Vegetables>


        -<Fruits>


        -<Food>

        <name>Apples</name>

        <image>apples</image>

        <canningMethod>Quantity: An average of 19 pounds is needed per canner load of 7 quarts; an average of 12-1/4 pounds is needed per canner load of 9 pints. A bushel weighs 48 pounds and yields 16 to 19 quarts-an average of 2-3/4 pounds per quart.Quality: Select apples that are juicy, crispy, and preferably both sweet and tart.Please read Using Pressure Canners and Using Boiling Water Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash, peel, and core apples. To prevent discoloration, slice apples into water containing ascorbic acid. Raw packs make poor quality products. Place drained slices in large saucepan and add 1 pint water or very light, light, or medium syrup per 5 pounds of sliced apples. Boil 5 minutes, stirring occasionally to prevent burning. Fill jars with hot slices and hot syrup or water, leaving 1/2-inch headspace. Adjust lids and process.Processing directions for canning sliced apples in a boiling-water, a dial, or a weighted-gauge canner are given in Table 1, Table 2, and Table 3. Tables at URl</canningMethod>

        <freezingMethod>Preparation – Syrup Pack is preferred for apples to be used for uncooked desserts or fruit cocktail. A sugar or dry pack is good for pie making.Select full-flavored apples that are crisp and firm, not mealy in texture. Wash, peel and core. Slice medium apples into twelfths, large ones into sixteenths.Syrup Pack – Use cold 40 percent syrup. To prevent browning, add 1/2 teaspoon (1500 mg) ascorbic acid to each quart of syrup.Slice apples directly into syrup in container starting with 1/2 cup syrup to a pint container. Press fruit down in containers and add enough syrup to cover. Leave headspace. Place a small piece of crumpled water-resistant paper on top to hold fruit down. Seal and freeze.Sugar Pack – To prevent darkening, dissolve 1/2 teaspoon (1500 mg) ascorbic acid in 3 tablespoons water. Sprinkle over the fruit. Or, apple slices can be steam blanched for 11/2 to 2 minutes.Mix 1/2 cup sugar with 1 quart (1 1/4 pounds) of fruit. Pack apples into containers and press fruit down, leaving headspace. Seal and freeze.Dry Pack – Follow the directions for Sugar Pack, omitting the sugar. Treated apple slices can also be frozen first on a tray and then packed into containers as soon as they are frozen. For more information, see other unsweetened packs.</freezingMethod>

        <dryingMethod>https://www.shelovesbiscotti.com/homemade-oven-baked-apple-chips/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/apple_sliced.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/apple.html</freezingUrl>

        <dryingUrl>https://www.shelovesbiscotti.com/homemade-oven-baked-apple-chips/</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Apricots</name>

        <image>apricots</image>

        <canningMethod>Quantity: An average of 16 pounds is needed per canner load of 7 quarts; an average of 10 pounds is needed per canner load of 9 pints. A bushel weighs 50 pounds and yields 20 to 25 quarts-an average of 2¼ pounds per quart.Quality: Select firm, well-colored mature fruit of ideal quality for eating fresh.Please read Using Pressure Canners and Using Boiling Water Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Wash fruit well if skins are not removed. (Optional procedure for removal of skins - Dip washed fruit in boiling water for 30 to 60 seconds until skins loosen. Dip quickly in cold water and slip off skins.) Cut prepared apricots in half, remove pits and slice if desired. To prevent darkening, keep peeled fruit in ascorbic acid solution. Prepare and boil a very light, light, or medium syrup or pack apricots in water, apple juice, or white grape juice.Raw packs make poor quality apricots.Hot pack – In a large saucepan place drained fruit in syrup, water, or juice and bring to boil. Fill jars with hot fruit and cooking liquid, leaving ½-inch headspace. Place halves in layers, cut side down.Raw pack – Fill jars with raw fruit, cut side down, and add hot water, juice, or syrup, leaving ½-inch headspace.Adjust lids and process.Processing directions for canning apricots in a boiling-water canner are given in Table 1.Processing directions for canning apricots in a dial or weighted-gauge canner are given in Table 2 and Table 3.Tables info in URL.</canningMethod>

        <freezingMethod>Preparation – Select firm, ripe, uniformly yellow apricots. Sort, wash, halve and pit. Peel and slice if desired. If apricots are not peeled, heat them in boiling water 1/2 minute to keep skins from toughening during freezing. Cool in cold water and drain.Syrup Pack – Use cold 40 percent syrup. For a better quality frozen product, add 3/4 teaspoon (2250 mg) ascorbic acid to each quart of syrup. Pack apricots directly into containers. Cover with syrup, leaving headspace. Place a small piece of crumpled water-resistant paper on top to hold fruit down. Seal and freeze.Sugar Pack – Before combining apricots with sugar, give the fruit the following treatment to prevent darkening:Dissolve 1/4 teaspoon (750 mg) ascorbic acid in 3 tablespoons cold water and sprinkle over 1 quart (7/8 pound) of fruit. Mix 1/2 cup sugar with each quart of fruit. Stir until sugar is dissolved. Pack apricots into containers and press down until fruit is covered with juice, leaving headspace. Place a small piece of crumpled water-resistant paper on top to hold fruit down. Seal and freeze.</freezingMethod>

        <dryingMethod>https://www.wikihow.com/Dry-Apricots#:~:text=Line%20a%20baking%20sheet%20with,to%20dry%20apricots%2C%20read%20on!</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/apricot_sliced.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/apricot.html</freezingUrl>

        <dryingUrl>https://www.wikihow.com/Dry-Apricots#:~:text=Line%20a%20baking%20sheet%20with,to%20dry%20apricots%2C%20read%20on!</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Avocados</name>

        <image>avocados</image>

        <canningMethod>Here’s a quick and easy pickling solution. Multiply by the number of avocados you have.Ingredients1 ripe but firm avocado4 tablespoons vinegar2 tablespoons water (optional)1 to 2 teaspoons sugar (or to taste)1/2 teaspoon salt (or to taste)(see variations below)DirectionsChoose firm but ripe avocados. Peel, pit, and slice or cube the avocado flesh.In a bowl large enough to hold the avocado pieces, stir together vinegar, water, sugar, and salt until sugar and salt are completely dissolved.Pour vinegar mixture over slices or cubes of avocado.Cover, refrigerate, and use within 3 days.</canningMethod>

        <freezingMethod>Preparation – Select avocados that yield to gentle pressure with rinds free from dark blemishes. Peel fruit, cut in half and remove pit.Avocados are best frozen as purée – unsweetened for salads and sandwiches, sweetened for other uses. Avocados are not satisfactorily frozen whole or sliced. For a better quality product, add 1/4 teaspoon (750 mg) ascorbic acid to each quart of purée or add 1 tablespoon lemon juice for each 2 avocados.Pack into container, leaving headspace. Seal and freeze. </freezingMethod>

        <dryingMethod>https://www.dryingallfoods.com/dehydrating-avocado/</dryingMethod>

        <canningUrl>http://www.homepreservingbible.com/2724-avocado-preserving-methods/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/avocado.html</freezingUrl>

        <dryingUrl>https://www.dryingallfoods.com/dehydrating-avocado/</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Bananas</name>

        <image>banana</image>

        <canningMethod>Bananas can be used as an ingredient in home canning, but they can’t be canned plain on their own.</canningMethod>

        <freezingMethod>Preparation – Select firm ripe bananas. Peel; mash thoroughly. Add 1/2 teaspoon (1500 mg) ascorbic acid per cup of mashed banana. Package in moisture-vapor resistant container. Seal and freeze. </freezingMethod>

        <dryingMethod>https://naturallyella.com/baked-banana-chips/#:~:text=Slice%20bananas%20into%201%2F16,out%2C%202%2D3%20hours.</dryingMethod>

        <canningUrl>https://www.healthycanning.com/canning-bananas/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/banana.html</freezingUrl>

        <dryingUrl>https://naturallyella.com/baked-banana-chips/#:~:text=Slice%20bananas%20into%201%2F16,out%2C%202%2D3%20hours.</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Berries</name>

        <image>berries</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/berries_whole.html</canningMethod>

        <freezingMethod>Preparation – Select full-flavored, ripe berries. Remove leaves, stems and immature or defective berries.Dry Pack – Do not wash berries. Washing results in a tougher skinned product. Pack berries into containers, leaving headspace. Berries can also be frozen first on a tray and then packed into containers as soon as they are frozen. Seal and freeze. Wash before using.Crushed or Puréed – Wash the berries. Crush, press berries through a fine sieve, or purée in a blender or food processor. Mix 1 to 1 1/8 cups of sugar with each quart (2 pounds) of crushed berries or purée. Stir until sugar is dissolved. Pack into containers, leaving headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>https://jomygosh.com/2015/01/easiest-way-to-dry-blueberries-ever/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/berries_whole.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/blueberry.html</freezingUrl>

        <dryingUrl>https://jomygosh.com/2015/01/easiest-way-to-dry-blueberries-ever/</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Cherries</name>

        <image>cherries</image>

        <canningMethod>Sweet or Sour Cherries - WholeQuantity: An average of 17½ pounds is needed per canner load of 7 quarts; an average of 11 pounds is needed per canner load of 9 pints. A lug weighs 25 pounds and yields 8 to 12 quarts – an average of 2½ pounds per quart.Quality: Select bright, uniformly colored cherries that are mature (of ideal quality for eating fresh or cooking).Please read Using Pressure Canners and Using Boiling Water Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Stem and wash cherries. Remove pits if desired. If pitted, place cherries in water containing ascorbic acid to prevent stem-end discoloration. If canned unpitted, prick skins on opposite sides with a clean needle to prevent splitting. Cherries may be canned in water, apple juice, white-grape juice, or syrup. If syrup is desired, select and prepare preferred type as directed.Hot pack – In a large saucepan add ½ cup water, juice, or syrup for each quart of drained fruit and bring to boil. Fill jars with cherries and cooking liquid, leaving ½-inch headspace.Raw pack – Add ½ cup hot water, juice, or syrup to each jar. Fill jars with drained cherries, shaking down gently as you fill. Add more hot liquid, leaving ½-inch headspace. Adjust lids and process.Processing directions for canning cherries in a boiling-water, a dial, or a weighted-gauge canner are given in Table 1, Table 2, and Table 3. Tables at URL</canningMethod>

        <freezingMethod>Preparation – Select bright, fully ripened cherries of dark colored varieties. Wash, stem and pit.Syrup Pack – Use cold, 40 percent syrup. For a better quality product add 1/2 teaspoon (1500 mg) ascorbic acid to each quart syrup. Pack fruit and cover with syrup, leaving headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>https://www.thespruceeats.com/how-to-dry-cherries-dehydrator-method-1327532</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/cherry_whole.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/cherry_sweet.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/how-to-dry-cherries-dehydrator-method-1327532</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Chokecherries</name>

        <image>chokecherries</image>

        <canningMethod>ChokeCherry JellyIngredients4 cups chokecherry juice1/4 cup of lemon juice1 1/2– 2 cups sugar OR 1 1/2 cups honey4 t. Pomona’s Pectin (like this)4 t. calcium water (included in Pomona’s pectin)InstructionsStep 1: *How to Make Chokecherry Juice* If you have a juicer, use it! I don’t, so I use this method:Clean, wash, and remove stems from berriesPlace in a large pot filled with enough water to just cover the fruitSimmer 15-30 minutes until fruit softensUse a potato masher to mash the juice outStrain through a cheesecloth-lined colander or jelly strainerSave the juice and discard pulp/pitsStep 2: Mix chokecherry juice, lemon juice, and 4 teaspoons calcium water in a potThoroughly mix sugar or honey in separate bowl with 4 teaspoons pectin & set asideStep 3: Bring juice mixture to a boilAdd pectin/sugar mixture, mix until completely incorporated, then return to a boilRemove from heat, get ready to place it in your sterilized canning jarsStep 4: Fill the jars, leaving 1/4″ headspaceBoil in a hot-water bath canner 10 minutes (add an extra minute for every 1,000 feet you are above sea level)</canningMethod>

        <freezingMethod>Preparation – Select bright red, tree ripened cherries. Wash, stem and pit.Syrup Pack – Pack cherries into containers and cover with cold 50 per cent syrup. Leave headspace. Seal and freeze.Sugar Pack – To 1 quart (1 and 1/3 pounds) cherries add 3/4 cup sugar. Mix until sugar is dissolved. Pack into containers, leaving headspace. Seal and freeze.</freezingMethod>

        <dryingMethod>https://openprairie.sdstate.edu/cgi/viewcontent.cgi?article=1485&context=extension_extra#:~:text=Lay%20the%20patties%20on%20a,hot%2C%20soapy%20water%20and%20dried.&text=Leave%20about%201%2F2%20inch,occur%20throughout%20the%20drying%20process.&text=Chokecherry%20patties%20will%20take%2012%2D16%20hours%20to%20dry.</dryingMethod>

        <canningUrl>https://www.theprairiehomestead.com/2012/08/how-to-make-chokecherry-jelly-low-sugar-and-honey-variations.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/cherry_sour.html</freezingUrl>

        <dryingUrl>https://openprairie.sdstate.edu/cgi/viewcontent.cgi?article=1485&context=extension_extra#:~:text=Lay%20the%20patties%20on%20a,hot%2C%20soapy%20water%20and%20dried.&text=Leave%20about%201%2F2%20inch,occur%20throughout%20the%20drying%20process.&text=Chokecherry%20patties%20will%20take%2012%2D16%20hours%20to%20dry.</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Citrus Fruits</name>
//lemon curd
        <image>citrus_fruits</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/lemon_curd.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/freezer_lemoncurd.html</freezingMethod>

        <dryingMethod>https://www.trail.recipes/dehydrating123/dehydrating123-why-and-how-to-dehydrate-citrus-fruits/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/lemon_curd.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/freezer_lemoncurd.html</freezingUrl>

        <dryingUrl>https://www.trail.recipes/dehydrating123/dehydrating123-why-and-how-to-dehydrate-citrus-fruits/</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Crabapple</name>

        <image>crabapple</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/crab_apple_spiced.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/apple.html</freezingMethod>

        <dryingMethod>https://homecookedvegan.blogspot.com/2016/01/dehydrated-crab-apples.html</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/crab_apple_spiced.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/apple.html</freezingUrl>

        <dryingUrl>https://homecookedvegan.blogspot.com/2016/01/dehydrated-crab-apples.html</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Currants Figs</name>

        <image>currants_figs</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/fig.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/fig.html</freezingMethod>

        <dryingMethod>https://www.wikihow.com/Dry-Figs#:~:text=To%20dry%20figs%2C%20start%20by,for%20up%20to%2036%20hours.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/fig.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/fig.html</freezingUrl>

        <dryingUrl>https://www.wikihow.com/Dry-Figs#:~:text=To%20dry%20figs%2C%20start%20by,for%20up%20to%2036%20hours.</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Grapes</name>

        <image>grapes</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/grapes_whole.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/grape.html</freezingMethod>

        <dryingMethod>https://www.seriouseats.com/recipes/2017/02/oven-dried-grapes-raisins-recipe.html</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/grapes_whole.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/grape.html</freezingUrl>

        <dryingUrl>https://www.seriouseats.com/recipes/2017/02/oven-dried-grapes-raisins-recipe.html</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Melons</name>

        <image>melons</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/green_mangoes.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/melon.html</freezingMethod>

        <dryingMethod>http://www.homepreservingbible.com/888-how-to-dry-melon-slices/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/green_mangoes.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/melon.html</freezingUrl>

        <dryingUrl>http://www.homepreservingbible.com/888-how-to-dry-melon-slices/</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Mint/Herbs</name>

        <image>mint</image>

        <canningMethod>https://canningdiva.com/canning-mint-jelly/</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/herbs.html</freezingMethod>

        <dryingMethod>https://www.thespruce.com/how-to-dry-and-store-herbs-1403397</dryingMethod>

        <canningUrl>https://canningdiva.com/canning-mint-jelly/</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/herbs.html</freezingUrl>

        <dryingUrl>https://www.thespruce.com/how-to-dry-and-store-herbs-1403397</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Peaches</name>

        <image>peaches</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/peach_sliced.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/peach.html</freezingMethod>

        <dryingMethod>https://www.thespruceeats.com/dry-peaches-in-a-dehydrator-1327526</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/peach_sliced.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/peach.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/dry-peaches-in-a-dehydrator-1327526</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Pears</name>

        <image>pears</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/pear_halved.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/pear.html</freezingMethod>

        <dryingMethod>https://www.thespruceeats.com/how-to-dry-pears-in-dehydrator-1327580</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/pear_halved.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pear.html</freezingUrl>

        <dryingUrl>https://www.thespruceeats.com/how-to-dry-pears-in-dehydrator-1327580</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Pineapple</name>

        <image>pineapple</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/pineapple.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/pineapple.html</freezingMethod>

        <dryingMethod>https://selfproclaimedfoodie.com/oven-dried-pineapple/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/pineapple.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pineapple.html</freezingUrl>

        <dryingUrl>https://selfproclaimedfoodie.com/oven-dried-pineapple/</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Plums</name>

        <image>plums</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/plum_halved.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/plum.html</freezingMethod>

        <dryingMethod>https://frugalfamilyhome.com/food/drying-foods/how-to-dry-plums</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/plum_halved.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/plum.html</freezingUrl>

        <dryingUrl>https://frugalfamilyhome.com/food/drying-foods/how-to-dry-plums</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Quince</name>

        <image>quince</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/asian_pears.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/pear.html</freezingMethod>

        <dryingMethod>http://www.homepreservingbible.com/wp-content/uploads/2013/11/Preserving-Apples-Pears-and-Quince.pdf</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/asian_pears.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/pear.html</freezingUrl>

        <dryingUrl>http://www.homepreservingbible.com/wp-content/uploads/2013/11/Preserving-Apples-Pears-and-Quince.pdf</dryingUrl>

        <type>fruit</type>

        </Food>


        -<Food>

        <name>Strawberries</name>

        <image>strawberries</image>

        <canningMethod>https://nchfp.uga.edu/how/can_02/berries_whole.html</canningMethod>

        <freezingMethod>https://nchfp.uga.edu/how/freeze/strawberry.html</freezingMethod>

        <dryingMethod>https://www.shelovesbiscotti.com/oven-dried-strawberries/</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_02/berries_whole.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/strawberry.html</freezingUrl>

        <dryingUrl>https://www.shelovesbiscotti.com/oven-dried-strawberries/</dryingUrl>

        <type>fruit</type>

        </Food>

        </Fruits>


        -<Meats>


        -<Food>

        <name>Chicken</name>

        <image>chicken</image>

        <canningMethod>Chicken or RabbitPlease read Using Pressure Canners before beginning. If this is your first time canning, it is recommended that you read Principles of Home Canning.Procedure: Choose freshly killed and dressed, heathy animals. Large chickens are more flavorful than fryers. Dressed chicken should be chilled for 6 to 12 hours before canning. Dressed rabbits should be soaked 1 hour in water containing 1 tablespoon of salt per quart, and then rinsed. Remove excess fat. Cut the chicken or rabbit into its suitable size parts for fitting into your jars leaving required headspace. Can with or without bones. The hot pack is preferred for best liquid cover and quality during storage. Natural poultry fat and juices are usually not enough to cover the meat in raw packs.Hot pack – Boil, steam or bake meat until about two-thirds done. Add 1 teaspoon salt per quart to the jar, if desired. Fill jars with pieces and hot broth, leaving 1-1/4 inch headspace.Raw pack – Add 1 teaspoon salt per quart, if desired. Fill jars loosely with raw meat pieces, leaving 1-1/4 inch headspace. Do not add liquid.Adjust lids and process following the recommendations in Table 1 or Table 2 according to the canning method used.</canningMethod>

        <freezingMethod>Select only high quality, fresh poultry to freeze. The tender young bird is best for roasting, frying and broiling. Choose the more flavorful older birds for braising or stewing.Package poultry in freezer paper or wrap using the drugstore or butcher wrap, or place in freezer bags. Storebought poultry needs to be over-wrapped before freezing because its clear wrap is not moisture-vapor resistant. When packaging pieces, arrange them to form a compact, square, flat package so they will stack better in the freezer. After packaging, seal and freeze immediately.Quail, dove, duck, pheasant and other game birds should be dressed and gutted as soon as possible after shooting. Cool and clean properly. Remove excess fat on wild ducks and geese since it becomes rancid very quickly. Freeze as directed for poultry.Do not stuff poultry or game birds before freezing them. During freezing or thawing times, bacteria that cause foodborne illness could easily grow in the stuffing. Commercially stuffed frozen poultry is prepared under special safety conditions that cannot be duplicated at home.</freezingMethod>

        <dryingMethod>No links available.</dryingMethod>

        <canningUrl>https://nchfp.uga.edu/how/can_05/chicken_rabbit.html</canningUrl>

        <freezingUrl>https://nchfp.uga.edu/how/freeze/poultry.html</freezingUrl>

        <dryingUrl>No links available.</dryingUrl>

        <type>meat</type>

        </Food>


        -<Food>

        <name>Red Meat</name>

        <image>red_meat</image>

        <canningMethod>(Hot Pack Method for Canning Meat)Beef, venison, elk, or pork; Salt (optional); Water; Canning jars, lids, and rings (quarts or pints are fine); A pressure cannerTrim the meat to remove excess fat and gristle. (I usually try to do this when the meat is half-frozen. It makes the trimming much easier) Slice into strips against the grain, and then cut into roughly 1″ cubes (just eyeball it– no need to be exact). how to can beef, venison, or elk with a pressure canner for fork-tender meat! Place the cubes into a large stockpot and brown thoroughly on all sides. If your meat is especially lean, you may need to add a bit of fat (such as bacon grease, lard, or coconut oil) to the pan to prevent stickage. (Yes, that’s a word) The goal here is to simply brown the cubes— you don’t need to cook them all the way through.Canning Meat TutorialPlace the browned meat cubes into clean glass jars, leaving 1″ headspace. If using quart jars, add 1 teaspoon of salt. If using pint jars, add 1/2 teaspoon of salt. Canning Meat Tutorial: how to can beef, venison, or elk with a pressure canner for fork-tender meat! Pour water (how much you need will depend on how many jars you are canning) into the pot you used to brown the meat, and bring it to a boil. This will capture all the lovely bits from the bottom of the pot and create extra flavor in your finished product. Ladle the boiling water over the meat in the jars, leaving 1″ headspace. Wipe the rims, adjust the lids/rings, and process in a steam pressure canner as follows:Pints: 75 minutesQuarts: 90 minutesUse 10 pounds of pressure, UNLESS you are 1,000 feet or more above sea level. If that is the case, increase to 15 pounds of pressure.</canningMethod>

        <freezingMethod>Cutting steaks from a big piece of meat like a strip loin or a boneless rib roastallows you to make steaks just the right thickness. Grill some of the steaks now and freeze theremaining ones for another day. Here's how: The key to freezing a steak properly is to preventair from touching the surface of the meat. Wrap each steak individually with plastic wrap, notbutcher paper or aluminum foil, and seal it as tightly as possible. Place the wrapped steaks in aresealable freezer bag and set the freezer as close to 0°F as it will go. The colder, the better.Steaks packaged this way will keep very well for about 3 months. </freezingMethod>

        <dryingMethod>No links available.</dryingMethod>

        <canningUrl>https://www.theprairiehomestead.com/2015/01/canning-meat.html</canningUrl>

        <freezingUrl>https://www.weber.com/CA/en/grill-skills/mastering-red-meat/steak/freezing-steaks/weber-34455.html#:~:text=Wrap%20each%20steak%20individually%20with,well%20for%20about%203%20months.</freezingUrl>

        <dryingUrl>No links available.</dryingUrl>

        <type>meat</type>

        </Food>


        -<Food>

        <name>Fish</name>

        <image>fish</image>

        <canningMethod>Gather your canning supplies: Pressure canner,canning jars, canning lids and rings jar lifter and canning funnel, stock pot, bowls, large spoons, sharp knife, towels and dish clothes.Ingredients: Fish, Canning saltFirst, clean your fish. You'll need to remove the head, tail, and all fins and scales. Wash well and split fish lengthwise. Cut fish into jar-length pieces.Large piece of fish. Washing fish. Cutting fish. Soak your fish in a salty brine for 1 hour. Use 1 cup of salt to 1 gallon of water. (This technique came from my Ball Blue Book, and I would think that brining would be especially helpful for flavor if the fish is fresh caught.)While fish is soaking, gather all materials needed. Start your water heating in your canner. See pressure canning for more detailed instructions.Drain fish for 10 minutes. You want to be sure it is well drained. Draining fish. Packing jars. Pack fish into hot jars (pints or half pints), skin sides out next to the glass. Leave a 1-inch headspace. Do not add liquid. Place lids and process according to pressure canning instructions.Process pints or half pints 1 hour 40 minutes at 10 pounds pressure.</canningMethod>

        <freezingMethod>Fresh fish is a tasty protein that has a relatively short shelf life. Any fish you are not planning on eating within a few days must be frozen. Properly freezing a fish does not mean tossing it into the freezer. Here's what you need to know to have top-quality fish for months:Air is your enemy. Any air that touches your fish will destroy it. It's that simple. So you must prevent air from contacting the fish by vacuum-sealing it, glazing it or wrapping it tightly. (This is in order of preference.)If you catch a lot of fish or buy lots of fresh fish from the market, buy a vacuum sealer. They're worth every penny and you'll use them frequently.If you choose not to vacuum seal, you can glaze the fish by dipping them in cold water and putting the dipped fish on a sheet pan in the freezer. Let that water freeze, then repeat the process several more times to get a 1/4 inch thick ice glaze on the fish. You can then put your glazed fish into a plastic bag and place in the freezer for storage.You can wrap your fish in plastic wrap, then put the wrapped fish into a plastic bag. This method is not as effective at preventing moisture loss and freezer burn like the other methods.</freezingMethod>

        <dryingMethod>No links available.</dryingMethod>

        <canningUrl>https://www.simplycanning.com/canning-fish.html</canningUrl>

        <freezingUrl>https://www.thespruceeats.com/tips-on-freezing-fish-1300632</freezingUrl>

        <dryingUrl>No links available.</dryingUrl>

        <type>meat</type>

        </Food>

        </Meats>

        </resources>
        
 */
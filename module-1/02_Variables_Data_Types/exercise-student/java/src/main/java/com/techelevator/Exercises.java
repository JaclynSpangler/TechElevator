package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int playingRaccoons = 3;
		int hungryRaccoons = 2;
		int numberOfRaccoonsLeft = playingRaccoons - hungryRaccoons;


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int flowers = 5;
		int bees = 3;
		int numberLessBeesThanFlowers = flowers - bees;



        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		int pigeonEating = lonelyPigeon + anotherPigeon;


        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int sittingOwls = 3;
		int joinedOwls = 2;
		int fenceOwls = sittingOwls + joinedOwls;



        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int workingBeavers = 2;
		int swimmingBeavers = 1;
		int leftBeavers = workingBeavers - swimmingBeavers;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int sittingToucans = 2;
		int joiningToucans = 1;
		int totalToucans = sittingToucans + joiningToucans;


        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrels = 4;
		int nuts = 2;
		int differenceSquirrelsAndNuts = squirrels - nuts;


        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double foundMoney = quarter + dime + (2 * nickel);





        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int muffinsBrier = 18;
		int muffinsMacAdams = 20;
		int muffinsFlannery = 17;
		int muffinsTotal = muffinsBrier + muffinsFlannery + muffinsMacAdams;


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double yoyo = 0.24;
		double whistle = 0.14;
		double twoToysTotal = yoyo + whistle;



        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int treats = 5;
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int inchesHiltsHouse = 29;
		int inchesBrecknockSchool = 17;
		int moreSnowAtHiltsHouse = inchesHiltsHouse - inchesBrecknockSchool;



        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double totalDollars = 10.00;
		double toyTruckCost = 3.00;
		double pencilCaseCost = 2.00;
		double spentMoney = toyTruckCost + pencilCaseCost;
		double moneyLeftOver = totalDollars - spentMoney;


        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int marblesBefore = 16;
		int lostMarbles = 7;
		int marblesAfterLost = marblesBefore - lostMarbles;



        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int seashells = 19;
		int seashellsNeed = 25 - seashells;





        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;



        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksOnShelf = 38;
		int booksAdded = 10;
		int booksTotal = booksOnShelf + booksAdded;



        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int beeLegs = 6;
		int eightBeeLegs = (8 * beeLegs);



        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double icecreamCone = 0.99;
		double icecreamConeTwo = (2 * icecreamCone);



        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int rocksForBorderTotal = 125;
		int rocksForBorderCurrently = 64;
		int rocksForBorderNeed = rocksForBorderTotal - rocksForBorderCurrently;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int marbles = 38;
		int otherLostMarbles = 15;
		int remainingMarbles = marbles - otherLostMarbles;



        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int totalMiles = 78;
		int drivenMiles = 32;
		int remainingMiles = totalMiles - drivenMiles;



        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */

		int minutes = 1;
		int hour = (60 * minutes);
		int snowSaturdayMorning = hour + (30 * minutes);
		int snowSaturdayAfternoon = (45 * minutes);
		int snowSaturdayTotal = snowSaturdayAfternoon + snowSaturdayMorning;




        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		double hotdogSingleCost = 0.50;
		int hotdogTotal = 6;
		double hotdogTotalCost = hotdogSingleCost * hotdogTotal;




        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		int totalHiltMoney = 50;
		int pencilCost = 7;
		int totalPencil = (totalHiltMoney / pencilCost);



        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int butterfliesTotal = 33;
		int orangeButterflies = 20;
		int redButterflies = butterfliesTotal - orangeButterflies;


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double candyCost = .54;
		double gaveTheClerk = 1.0;
		double changeKateGetsBack = gaveTheClerk - candyCost;



        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int currentTrees = 13;
		int moreTrees = 12;
		int futureAmountOfTrees = currentTrees + moreTrees;



        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int hours = 1;
		int hoursInDay = (24 * hours);
		int seeGrandmaDays = 2 * hoursInDay;



        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int kimCousinTotal = 4;
		int piecesOfGumPerCousin = 5;
		int totalPiecesOfGum = kimCousinTotal * piecesOfGumPerCousin;



        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double danTotalMoney = 3.00;
		double candyBarTotal = 1.00;
		double leftoverMoney = danTotalMoney - candyBarTotal;


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsInLake = 5;
		int peopleInBoats = 3;
		int totalPeopleInBoatsInLake = boatsInLake * peopleInBoats;



        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int legos = 380;
		int lostLegos = 57;
		int remainingLegos = legos - lostLegos;



        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int muffinsArthurBaked = 35;
		int muffinsArthurWants = 83;
		int muffinsArthurNeedsToBake = muffinsArthurWants - muffinsArthurBaked;



        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int differenceInCrayons = willyCrayons - lucyCrayons;



        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersPerPage = 10;
		int pagesOfStickers = 22;
		int totalNumberOfStickers = stickersPerPage * pagesOfStickers;



        /* Exercise 39
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int cupcakesTotal = 96;
		int childrenTotal = 8;
		double cupcakesForEachChild = cupcakesTotal / childrenTotal;



        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int cookieTotal = 47;
		int cookiesFitInJar = 6;
		int cookiesLeftOver = cookieTotal % cookiesFitInJar;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int croissants = 59;
		int neighbors = 8;
		int leftoverCroissants = croissants % neighbors;





        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int cookiesOnTray = 12;
		int totalCookiesOatmeal = 276;
		int totalTrays = totalCookiesOatmeal / cookiesOnTray;


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int servingSizePretzels = 12;
		int totalPretzels = 480;
		int totalServingsOfPRetzels = totalPretzels / servingSizePretzels;



        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakes = 53;
		int cupcakeInBox = 3;
		int cupcakeLeftAtHome = 2;
		int boxesGivenAway = lemonCupcakes / cupcakeInBox;



        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int carrotSticks = 74;
		int people = 12;
		int leftoverCarrotSticks = carrotSticks % people;



        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int teddyBears = 98;
		int bearsPerShelf = 7;
		int totalShelves = teddyBears / bearsPerShelf;


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int picturesInAlbum = 20;
		int totalPictures = 480;
		int totalAmountOfAlbums = totalPictures / picturesInAlbum;


        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int tradingCards = 94;
		int cardsFitInBox = 8;
		int totalFilledBoxes = tradingCards / cardsFitInBox;
		int cardsInUnfilledBox = tradingCards % cardsFitInBox;


        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int books = 210;
		int repairedShelves = 10;
		int booksPerRepairedShelf = books / repairedShelves;



        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		int croissantsChristina = 17;
		double guests = 7.0;
		double croissantsPerGuests = croissantsChristina / guests;



	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */
		double billPaintRoomHours = 2.15;
		double jillPaintRoomHours = 1.90;
		int room = 1;
		double billHourlyRate = room / billPaintRoomHours;
		double jillHourlyRate = room / jillPaintRoomHours;
		int totalRoomsPainted = 5;

		double amountJillAndBillPaintInAHour = billHourlyRate + jillHourlyRate;
		double totalHoursbyJillAndBill = totalRoomsPainted /amountJillAndBillPaintInAHour;




	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */

		String firstName = "Grace ";
		String middleInitial = "B.";
		String lastName = "Hopper, ";
		String fullName = lastName + firstName + middleInitial;




	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */

		int milesBetweenNewYorkAndChicago = 800;
		double milesAlreadyTraveled = 537.0;
		double percentageOfTripCompleted = (milesAlreadyTraveled / milesBetweenNewYorkAndChicago) * 100;
		int wholeNumberPercent = (int) percentageOfTripCompleted;


	}

}

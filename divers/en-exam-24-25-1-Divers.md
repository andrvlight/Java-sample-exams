---
title: Programming languages Java exam, 2024/2025-1
...


## Conditions

Do the following **right now**: make sure that no communication device is available to you.

- **Put away** phones, headphones, tablets, smartwatches etc.
- **Close** all chat programs, mail clients etc. (including Teams)
- **Keep these things off/away** during the exam.

During and after the exam.

- If you're found cheating (e.g. giving or receiving help or using forbidden materials) during or after the exam, you are not getting graded this semester.
- You are forbidden from sharing any part of your exam solution until the day after the exam.

About the code.

- Whenever a name is specifically given, use that name exactly.
- Follow good practices.

Submitting.

- When the time is nearly up (with about 10 minutes left to go), zip the project that you created and upload it into Canvas.
    - In the context menu, you can use "Küldés/Tömörített mappa" to create the zip.
- Don't pack the `jar` files, nor the demo.



## General

If your text editor provides IDE capabilities via addons, they must be disabled at the start of the exam.

All necessary (and permitted) content is available in the theory Canvas under Files.

- The Java API documentation.
- The JUnit documentation.
- `junit5-checkthat-demo.zip` and `junit5-all.jar`
- Click here to download the structural/suite tester.

Open `DiversTestSuite` and use the individual structural testers in it.

-   While solving the exercise parts, work with the individual structural testers in the listed order, not the whole suite.
    -   When you're done with the whole exercise, for a full score, the whole test suite must succeed.
-   A class is worth exactly `0` points if its structural tester doesn't fully succeed.
-   You may not modify the structural/suite tester code at all.
-   Solve the parts in the listed order. You may not proceed to the next part until fully implemented.
-   Tester points are shown as `6T` for example.


# Exercise: Divers simulation (50 points)

Our program simulates an operation to collect artifacts from the ocean. You can think of it as salvage diving.
While it draws inspiration from underwater exploration, it does not specifically represent underwater archaeology.

- If you are familiar with maritime archaeology, please note that the approach in this program is intentionally different.

For all types, the getters for the fields simply return the values contained in the corresponding fields unless otherwise specified.

## `Artefact`; `Sample`, `Waste` (15+3*2+4T points)

The `Artefact` class has a single constructor that takes location data and color as parameters. It represents an abstract template that also implements a `Marked` set of rules.

-   If location data is less than 3 characters or `null`, raise an `IllegalArgumentException` with no arguments.
-   The color is taken from the enum `Color`, there's no default value specified.
-   We'll assume that an artefact has always initally a `rigidStructure`.

### **Methods**

-   The method `extendLocationData()` changes the location data of the artefact, but the implementation is done by `Sample` and `Waste`.
-   To return the artifact, the `retrieve()` method modifies its structure. The specifics are further defined by `Sample` and `Waste`.
-   The textual representation of an artefact is structured like this: `LocationData: <value>, Color: <value>, isRigid: <value>`
    -   E.g. `LocationData: 109-RE, Color: RED, isRigid: true`.
- The equality check of an artifact is primarily determined by comparing the first three letters of the location data. Additionally, the color and structure must also be the same.

### Rest of collectables

There are two types of artefacts: `Sample` and `Waste`.

-   A `Sample` is not rigid by nature; the opposite applies to `Waste`. Neither is tagged initially. Keep in mind that `Waste` cannot have its rigid structure changed once set, so the `setRigidStructure()` method must have no effect for `Waste` objects.
-   The method `extendLocationData()` is similar for both. Extending the current data with the given information is sufficient.
-   If a `Sample` gets tagged, it remains tagged. However, every call will modify its rigid structure. In contrast, for `Waste`, it can only be tagged or untagged.
-   As for the method `retrieve()`:
    -   `Waste` extends the location data by adding `#KO` only if the artefact is tagged.
    -   `Sample` can extend the location data if it is rigid or tagged. However, to verify if it is acceptable, the combined length of the location data and the color must be greater than 9 and less than 14. If this condition is met, `#OK` is added; otherwise, `#NO` is added.
    -   If retrival for both is not possible, `null` is returned.


### Functional testing

In `ArtefactTest`, create the following tester methods, it is enough to make the functional tests on `Sample` only.

- `testRetrieve`: Verify that the `retrieve` method works correctly for a `Sample`.
    - **Initial retrieval**: When a `Sample` is not tagged and not rigid, it should return `null`.
    - **Valid retrieval**: After tagging the `Sample` and making it rigid, retrieving the `Sample` should work, and the correct suffix (`#OK` or `#NO`) should be added based on the length of the `locationData` and `color`.

- `testTag`: Test the functionality of tagging a `Sample`.
  - Initially, the sample is not tagged. After tagging, the sample should be tagged, and its rigid structure should change.
  - If tagged again, the rigid structure should switch (i.e., the rigid structure becomes `true`).

#### Equality and Textual Representation

- `testSampleEquals`: Verify that two `Sample` objects with identical location data and color are considered equal.
  - Ensure that the `equals` method correctly compares `Sample` objects and that `hashCode` returns consistent values.

- `testText`: Write a test to verify the textual representation of an `Artefact`.
    - The expected output will be:
        ```
        LocationData: RX-721, Color: BLUE, isRigid: false
        ```

## Reminder:
Before moving on to the next part of the exercise, ensure that both **structural** and **functional JUnit tests** of the `Sample` class pass successfully.



## `Diver`, `Dumper`, and `WrongArtefact` (7+4+1+0T points)

A `Diver` is responsible for collecting artefacts in the ocean. Each `Diver` belongs to a team, has a speciality color, and collects artefacts that match their speciality.

- Its constructor initializes the `teamId`, `specialityColor`, and `artefacts` fields using the provided values. The `teamId` represents the team the diver belongs to, and the `specialityColor` defines the diver's team color. The `artefacts` list is initialized as an empty list.

- A no-argument constructor uses default values for `teamId` (`"T1"`) and `specialityColor` (the first color in the `Color` enum), while also initializing the `artefacts` list as an empty list.

### **Methods**

- The specific getter `getArtefacts()` returns a **defensive copy** of the `artefacts` list to ensure **encapsulation**.

- A tagger method `tagArtefacts()` tags a list of artefacts based on specific rules for each team:
    - The **Green** team can tag any artefacts directly.
    - The **Red** team can only tag artefacts that have a rigid structure.
    - The **Blue** team cannot tag any artefacts at all.

- The method `tryToGetArtefact()` attempts to retrieve and add an artefact to the diver’s collection. It first checks if the artefact's color matches the diver’s speciality. If not, it returns false. If the colors match, it tries to retrieve the artefact, adding it to the collection if successful. If retrieval fails, the artefact is tagged, and the method returns false.

- For a forceful retrieval, the method `forceInsertArtefact()` inserts an artefact into the diver’s collection. If the artefact's color doesn’t match the diver’s speciality, a `WrongArtefact` exception is thrown with the message `Wrong Color`. If retrieval fails, the artefact is tagged and retrieval is retried. If it still fails and contains `#KO` (indicating waste), a `WrongArtefact` exception is thrown with the message `Got Waste`. If successful, the artefact is added to the collection.


The `Dumper` class is responsible for throwing artefacts into the ocean. It has only one method:
  - `dumpArtefacts()` generates and returns a list of n artefacts, alternating between `Waste` and `Sample` types. Each artefact is assigned a location and a color, with the colors cycling through in a repeating pattern which starts from `GREEN`. The `locationData` for each artefact is constructed using the formula: `100 + current iteration number`, followed by the first two letters of the color.
    - Example: if `n = 5`, the method will generate artefacts as follows:

    ```
    Artefact 1: "LocationData: 101-GR, Color: GREEN, isRigid: false"
    Artefact 2: "LocationData: 102-BL, Color: BLUE, isRigid: true"
    Artefact 3: "LocationData: 103-RE, Color: RED, isRigid: false"
    Artefact 4: "LocationData: 104-GR, Color: GREEN, isRigid: true"
    Artefact 6: "LocationData: 105-BL, Color: BLUE, isRigid: false"
    ```

### Functional testing

These classes do not need to be tested functionally.


## DivingOperation (12+1 points and 4*2T bonus)

In this part, you’ll implement the core functionality of the program, where the main operations take place.

- The `DivingOperation` class represents the entire operation of a group of divers (teams) retrieving artefacts. This class handles the setup of teams, artefact registration, and the operation itself, which involves the divers tagging and retrieving artefacts according to their roles and rules defined by the operation.
- A test for `conductOperation` and `prepareOperation` are worth 4 extra points each.

- The constructor initializes the `DivingOperation` object by creating a number of diver teams. The number of teams must be divisible by 3, and each team is assigned a unique team identifier (`T1`, `T2`, `T3`, etc.). Each team is then assigned a color based on its position in the iteration. The constructor creates teams in sets of three, each with a distinct color corresponding to the team’s speciality.


### **Methods**
- To add multiple artefacts, the `registerArtefacts()` method registers a list of artefacts, but registration is done only for those artefacts that are of the `GREEN` color. This ensures that only green artefacts are included in the operation.

- For any artefact, the `registerArtefact()` specialized method checks if an individual artefact has already been added to the list of artefacts. If not, it adds the artefact to the operation’s collection.

- Preparation must be done beforehand. The `prepareOperation()` method prepares the operation by simulating the artefact dumping process.
  - It retrieves a list of artefacts from the `Dumper` class, ensuring that at least one artefact is green.
    - To check if there is at least a green artefact, it is only allowed to check the first, third, middle, and last artefacts.
    - If no green artefacts are found, an `InvalidOperation` exception is thrown.

- To begin the operation, the `conductOperation()` method will be used the following way:
  - It involves each team of divers attempting to tag and retrieve artefacts.
  - Each team, through its divers, goes through the artefacts and tries to retrieve them.
  - If a diver is from the red team, the diver will also attempt to forcefully retrieve artefacts if they fail to retrieve them using the normal method. The forceful retrieval happens with a check to see if the artefact is a waste artefact (indicated by the `#KO` tag).
  - After all the artefacts are retrieved by the divers, the method collects the successfully retrieved artefacts in a `HashSet` and returns the final collection.
    - Example Flow of Operation:
        1. The `DivingOperation` constructor sets up diver teams, assigning them roles and colors, such as `T1` (Green), `T2` (Blue), and `T3` (Red).

        2. The `prepareOperation` method is called to dump artefacts into the environment, registering the green artefacts.

        3. During the `conductOperation` phase:
           - Divers from each team attempt to tag artefacts.
           - Green and Blue artefacts are to be peacefully retrieved by the respective teams.
           - Red team members attempt to retrieve artefacts, and if they fail, they forcefully retrieve them by tagging and retrying.

        4. At the end of the operation, a `HashSet` of all successfully retrieved artefacts is returned.

### Functional testing

As described above in the flow operation.

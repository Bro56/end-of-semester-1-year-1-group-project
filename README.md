1. Crop Farm Class and Sub-classes
General overview and purpose
In general, the crop farm module serves as an object-oriented foundation for modeling and managing agricultural crop production within the application, fulfilling the project requirements for object-oriented design and data management. Its core purpose is to provide a structured way to handle crop-related records, allowing the system to track what crops are being grown, their classifications, and their harvest yields.
Class structure and data stored (attributes)
The module is structured into a primary parent class and two specialized child classes. The data relies on protected attributes to encapsulate information safely while keeping it accessible to related sub-classes:
•	Name of Crop: stores the common name of the crop being cultivated.
•	Crop Type: specifies the category, variety, or classification of the crop.
•	quantity_produced: tracks the numerical volume or harvest yield produced by the farm.
The parent class (crop_farm)
Role and work: acts as the primary super class that establishes the core attributes and behavior shared across all crop production records. Constructor: a parameterized constructor initializes the crop name, crop type, and production quantity upon object creation. Main method: a base displayDetails() method prints the formatted details of a standard crop entity.
Child classes and their work
•	Child Class 1 (farm1): extends crop_farm to represent the first distinct type of crop production. It uses the inherited constructor to pass data upward and overrides displayDetails() to prepend a unique heading for the first farm type before executing the parent display logic.
•	Child Class 2 (farm2): extends crop_farm in a parallel structure to represent a second distinct category or type of crop production. It similarly uses the parent constructor and overrides displayDetails() with its own specialized header for the second crop category.
How the code works
The code operates through inheritance and polymorphism. When a crop object is created via farm1 or farm2, it invokes the parent crop_farm constructor using the super keyword to store its attributes. When the details need to be viewed, runtime polymorphism lets the specific child class run its overridden displayDetails() method, printing its custom section header and then delegating the core attribute printing back to the parent class via super.displayDetails().
How crop_farm connects with other classes
Within the broader architecture, the crop_farm class family acts as a modular, self-contained data entity. It works alongside other domain-specific components (animal management, inventory, transactions, and worker structures) to form a comprehensive agricultural management system. It organizes crop data so that it can interface seamlessly with user inputs and display components managed across the application's user interface.

2. Animal Farm Module
A simple explanation of how the system works with cows, goats, and chickens.
Purpose
This part of the project is about farm animals. It keeps each animal's name, breed, product type and amount produced for cows, goats and chickens, shown on cards in the Animals tab.
Class structure
AnimalFarm is the main parent class and holds the information all animals share. CowFarm, GoatFarm and ChickenFarm are child classes, each with its own product() method. AnimalManager stores the animals that are added.
Data stored
The AnimalFarm class has four private fields, read through getters: nameOfAnimal (the name of the animal, such as Cow), breed (the breed of the animal), outputType (what the animal gives, such as milk, meat or eggs) and quantity (how much is produced, saved by the constructor).
Main method: product()
The product() method shows the animal's production details. In AnimalFarm it is abstract, so the parent says the method must exist and the child classes write what it does. Each child class returns a message with the animal name, breed, amount and product type.
Child classes and their work
Class / Method	What it does
AnimalFarm	Stores the common details for all farm animals.
CowFarm	Product type: Milk/Meat.
GoatFarm	Product type: Milk/Meat.
ChickenFarm	Product type: Eggs/Meat.
product()	Returns the production details.

How the code works
The code uses inheritance, so the child classes get shared details from AnimalFarm through super(). It also uses method overriding, where each child class has its own version of product(). Because of this, one AnimalFarm variable can hold a cow, goat or chicken, which is called polymorphism. More animal types can be added later with new child classes. The animals are kept in memory only and are not saved to a database.
3. Inventory Management
Purpose
We designed the inventory module to track the supplies a farm depends on for its daily running, such as feed, seed and fertilizer. For each item it records the name, quantity, unit of measure, reorder level and storage location, so the farmer always knows what they have in stock and where it is kept.
Design
We applied object-oriented principles by separating responsibilities between two classes:
•	The Inventory class represents a single item and holds its data. It uses a constructor to set the initial values. Its methods are addStock(), which increases the quantity, and useStock(), which reduces it only when enough stock exists, returning true or false so the caller knows whether the request succeeded.
•	The InventoryManager class manages the whole collection: it collects input, stores these items and displays them.
Data storage
Items are stored in a fixed-size array, with a counter, currentIndex, tracking how many positions are filled. This keeps the logic simple and makes it easy to loop over only the items that exist. Its limitation is the fixed capacity, which an ArrayList could remove in future.
Input and display
The input method uses a loop that keeps asking for item details until the user types "done". After reading each number with nextDouble(), we call nextLine() to clear the leftover newline so the next text input is read correctly. The display method prints each item's details in a readable layout and shows a message when the inventory is empty.

4. WorkersManager Class
Description of the WorkersManager class
The WorkersManager class is responsible for managing all workers in the Farm Management System. It stores and organizes worker records using an array that can accommodate up to 100 workers. It provides methods for adding new workers, retrieving all registered workers, counting the total number of workers and searching for a specific worker by name.
How the WorkersManager class works
•	Storing workers: it uses a Worker array to store employee objects.
•	Adding workers: the addWorker() method checks whether there is available space before adding a new worker.
•	Retrieving workers: the getWorker() method returns all registered workers.
•	Counting workers: the getWorkerCount() method returns the total number of registered workers.
•	Searching workers: the getWorkerByName() method searches for a worker using their name.
Methods in the WorkersManager class
The following are methods, not subclasses. Each method performs a specific task in managing worker records.
Method	Function
addWorker()	Adds a new worker to the system if storage space is available.
getWorker()	Retrieves an array containing all registered workers.
getWorkerCount()	Returns the number of registered workers.
getWorkerByName()	Searches for and returns a worker using their name; returns null if no match is found.

How the code works
The system first creates an array to store Worker objects. When a new worker is added, the program checks whether the array has space. If space is available, the worker's details are stored and the worker count increases by one. The system can then retrieve all registered workers, display the number of workers or search for a particular worker by name. WorkersManager works together with the Worker class: the Worker class holds each worker's name, role, contact and salary information, while WorkersManager manages the collection of Worker objects.
Conclusion
The WorkersManager class acts as the central manager of worker records in the Farm Management System. It helps the farm administrator register, organize, retrieve and search for employee information efficiently.
 

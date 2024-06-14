Daniel Grace
CS401 Assignment 2 - Ecommerce
CSU Eastbay Summer 2024

USAGE SUMMARY: 
Compile and run program. Select a function from the user interface menu. Follow sub-prompts for desired functions. Continue to select new user actions as desired. When finished chose the menu option to "exit" the program. 


DETAILED DESCRIPTION:
The program implements a product library through the super class Products and the subclasses Clothing, Electronics, and Book. Each of which is a subtype of Products. The Products class includes a static list of all products; acting as a product catalog. 

The ShoppingCart class provides typicall e-com shopping cart functionality. It includes an inner class CartLine which serves to represent products and quantities that have been added to the class. The ShoppingCart class has an ArrayList of Cartlines which makeup the data structure of the cart. 

The ECommerceApp class acts as the main user interface for the E-Commerce experience. It provides user IO to reflect typical e-com functionality including: Browsing product catalog, viewing product details, adding a product to the card, viewing the cart, removing items from the cart, "checking out." 

ADDITIONAL INFORMATION:
Full documentation can be retrieved at: 
https://electriczer0.github.io/CS401-Assn-2---Ecommerce/
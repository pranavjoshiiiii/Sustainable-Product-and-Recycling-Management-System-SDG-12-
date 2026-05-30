# Week 9 Refactoring

## What is Refactoring?

Refactoring means cleaning up code that already works. You do not add new features and you do not fix bugs. You just make the code easier to read and understand. The program behaves exactly the same before and after.

---

## What We Did

We looked at our code and found three problems. Each person in the group picked one problem and fixed it on a separate branch. Before merging, we ran our tests to make sure nothing broke.

---

## Fix 1 — Renamed All Classes to Follow Java Naming Rules

**What was wrong:**
Our class names were all lowercase, for example `product`, `material`, and `activityLog`. In Java, class names are supposed to start with a capital letter. This is a basic rule that every Java project follows.

**What we changed:**
We renamed every class, interface, and enum to start with a capital letter.

| Old Name | New Name |
|----------|----------|
| `product` | `Product` |
| `material` | `Material` |
| `activityLog` | `ActivityLog` |
| `recyclingCategory` | `RecyclingCategory` |
| `recyclingGuidance` | `RecyclingGuidance` |
| `consoleUi` | `ConsoleUi` |
| `productService` | `ProductService` |
| `materialService` | `MaterialService` |
| `strategyFactory` | `StrategyFactory` |
| `simpleSumStrategy` | `SimpleSumStrategy` |
| `weightedByLifespanStrategy` | `WeightedByLifespanStrategy` |
| `impactCalculationStrategy` | `ImpactCalculationStrategy` |

We also updated every import statement across all files to match the new names.

**Problem we ran into:**
After renaming the files, the CI pipeline still failed. This happened because Git on Windows does not notice when you only change the letter case of a file name. The old names were still saved in the Git cache. We fixed it by clearing the cache and pushing again.

```bash
git rm -r --cached .
git add .
git commit -m "Fix Git cache for renamed files"
git push origin rename-classes
```

---

## Fix 2 — Removed Duplicated Code in ConsoleUi

**What was wrong:**
Inside `ConsoleUi`, we had the exact same block of code written twice. Once in `calculateImpact()` and again in `showRecyclingGuidance()`. Both methods were doing the same thing — showing a list of products and letting the user pick one.

This is a problem because if we ever need to change how product selection works, we would have to remember to update it in two places. That is easy to forget and causes bugs.

**Before — same code copied in two places:**

```java
System.out.println("Select a product:");
for (int i = 0; i < products.size(); i++) {
    System.out.println((i + 1) + ". " + products.get(i).getInfo());
}
int choice = Integer.parseInt(scanner.nextLine()) - 1;
product selected = products.get(choice);
```

**What we changed:**
We moved that block into its own method called `selectProduct()`. Both methods now call it instead of repeating the same code.

**After:**

```java
private product selectProduct(List<product> products) {
    System.out.println("Select a product:");
    for (int i = 0; i < products.size(); i++) {
        System.out.println((i + 1) + ". " + products.get(i).getInfo());
    }
    int choice = Integer.parseInt(scanner.nextLine()) - 1;
    return products.get(choice);
}
```

The logic did not change at all. We just moved it to one place.

---

## Fix 3 — Split menuLoop() Into Two Methods

**What was wrong:**
The `menuLoop()` method was doing two things at once. It was running the loop and also handling every single menu option inside a long if/else chain. A method should do one thing only. This is called the Single Responsibility Principle.

**Before:**

```java
public void menuLoop() {
    int choice = -1;
    while (choice != 0) {
        printMenu();
        choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            addProduct();
        } else if (choice == 2) {
            listProducts();
        } else if (choice == 3) {
            addMaterial();
        } // ... and so on
    }
}
```

**What we changed:**
We moved the if/else block into a new method called `handleMenuChoice()`. Now `menuLoop()` only runs the loop and `handleMenuChoice()` only handles what happens when the user picks an option.

**After:**

```java
public void menuLoop() {
    int choice = -1;
    while (choice != 0) {
        printMenu();
        choice = Integer.parseInt(scanner.nextLine());
        handleMenuChoice(choice);
    }
}

private void handleMenuChoice(int choice) {
    if (choice == 1) {
        addProduct();
    } else if (choice == 2) {
        listProducts();
    } else if (choice == 3) {
        addMaterial();
    } else if (choice == 4) {
        listMaterials();
    } else if (choice == 5) {
        calculateImpact();
    } else if (choice == 6) {
        showRecyclingGuidance();
    } else if (choice == 0) {
        System.out.println("Goodbye!");
    } else {
        System.out.println("Invalid option, try again.");
    }
}
```

---

## How We Worked

We followed the refactoring cycle from the lecture:

1. Made sure all tests were green before starting
2. Each person made their changes on a separate branch
3. Opened a Pull Request into `development`
4. CI ran the tests automatically on every push
5. Waited for green before merging

```
main
 └── development
      ├── rename-classes
      ├── extract-select-product
      └── extract-handle-menu-choice
```

---

## Outcome

All three fixes are merged into `development`. The program works exactly the same as before. All tests pass. The code is now easier to read and follow.

# Sustainable Product and Recycling Management System SDG 12

## Project Description
This project is a structured, menu-driven console application developed. It is designed to manage products and reusable materials, compute environmental impact metrics, and provide recycling guidance. The system is built with a strong focus on software engineering principles, including architecture, clear separation of responsibilities, testability, maintainability, and comprehensive documentation. Additionally, it reflects a professional development workflow rather than focusing solely on feature implementation.


## Purpose of system
-	Help users understand how to dispose of and reuse products correctly.	
-	Reduce environmental waste by encouraging sustainable habits.
-   Provide useful information about product lifecycle and recycling methods.
-	Allow users to track their personal contribution to saving the environment.
-   A CI/CD pipepline and comprehensive UML documentation (Class and Sequence Diagrams).


## Group Members and Roles
- ***Abdul Bari Iqbal Chaudhry*** - Technical & Documentation 
- ***Vikram Khajuria*** - Manages github repository, branches and ensures clean code principles
- ***Pranav Joshi*** - UI console & code 

 ***Shared Roles***
- Shared roles are to learn the architecture together and implement things by collaborations.
- Goal is to learn the coding, logic seperations, testing and mock objects.
  


## Requirement Extraction

### Functional Requirements:
- Product Management
  - Create
  - List
  - Information Detail
- Material Management
  - Recycling Category
  - Reusability
- Environmental Impact Calculation
  - Total Impact Calculation
  - Interchangeable Strategies
  - Startegy Pattern
- Recycling Guidance
  - Material Composition
  - Mixed-Material Documentation

### Non-Functional Requirements:
- Arquitectural
  - Application Type: Menu Driven Console
  - Layered Arquitecture: Presentation & Domain visualization 
  - Strict Separation Between UI & Business Logic
  - Strategy Patterns: Documented
  - JUnit Tests: No console UI code in tests

- Qualities & Constraints
  - Maintainability
  - Continuous Integration: Builds projects and runs tests automatically
  - Meaningful commits


## Domain Concept Identification

| Concepts(Nouns) | Responsibilities(verbs) |
|------|-----|
| Product | Create |
| Material | List |
| Impact | View |
| Category | Calculate |
| Lifespan | Define |  
| Strategy | Provide |
| Recycling Guidance | Replace |

## System Boundaries



## Weekwise  project overview:

Week 1 – Understanding the System
In Week 1, we focused on understanding the problem and what the system is supposed to do. We
identified key functional requirements such as managing products, calculating environmental
impact, and providing recycling guidance. We also defined the system boundary by deciding what is
inside the system and what is outside, like UI frameworks.
We extracted important domain concepts like Product, Material, and RecyclingCategory, and
classified them into entities, value objects, and services. Finally, we created a basic UML diagram
and a README to document our understanding. Overall, Week 1 was about building a clear
foundation.
  
Week 2 – Building the Domain Model
In Week 2, we structured the system using CRC cards. For each class, we defined its
responsibilities, what data it owns, and which other classes it collaborates with. This helped us
assign responsibilities more clearly.
We identified classes such as Product, Material, RecyclingCategory, RecyclingGuidance, and
ImpactCalculationStrategy. Then we converted these into a UML Class Diagram (v1). At this stage,
the structure was clearer, but still had design issues. Week 2 was mainly about organizing the
system into meaningful classes.
  
Week 3 – Improving the Design
In Week 3, we reviewed our model and identified design problems using principles like SRP, OCP,
and DIP.
We noticed that some classes, especially Product, had too many responsibilities. This violates the
Single Responsibility Principle because one class should have only one reason to change.
To fix this, we separated responsibilities. Product now only represents product data, while
calculation logic is handled by strategy classes and recycling logic by a separate service.
We also introduced a strategy-based design for impact calculation, which follows the Open/Closed
Principle. This allows us to add new calculation methods without modifying existing code.
Overall, Week 3 improved the design by making it more flexible, maintainable, and easier to extend.

## Week 4 — Layered Architecture

### Package Structure

The system follows a strict four-layer architecture where dependencies point inward — outer layers depend on inner layers, never the reverse.

### Package Responsibilities

| Package | Classes | Responsibility |
|---|---|---|
| `Domain` | `Product`, `Material`, `User`, `RecyclingCategory`, `ActivityLog`, `ImpactCalculationStrategy`, `SimpleSumStrategy`, `WeightedByLifespanStrategy`, `RecyclingGuidance` | Pure business rules and entities. No imports from outer layers. Fully unit-testable in isolation. |
| `Application` | `ProductService`, `MaterialService` | Use-case orchestration. Coordinates domain objects. No UI code, no Scanner, no System.out. |
| `Presentation` | `ConsoleUI`, `Menu` | All user-facing I/O. Reads input, prints output, delegates to application layer. No business logic. |
| `Startup` | `Main` | Composition root. The only place where concrete classes are instantiated and wired together. No business logic. |

### Dependency Direction

- `Presentation` depends on `Application`
- `Application` depends on `Domain`
- `Domain` depends on nothing outside itself
- `Main` wires everything together at launch

### Interface Placement Rationale (DIP)

`ImpactCalculationStrategy` is defined as an interface in `Domain`. The interface belongs to the layer that uses it — `ProductService` in `Application` depends on the abstraction. `SimpleSumStrategy` and `WeightedByLifespanStrategy` implement it. `Main` decides which concrete strategy to inject at runtime.

### Walking Skeleton

`Main` serves as the composition root and proves the wiring works end-to-end:

```java
SimpleSumStrategy strategy = new SimpleSumStrategy();
ProductService productService = new ProductService(strategy);
ConsoleUI ui = new ConsoleUI(productService);
ui.menuLoop();
```

[Week 4 UML](UmlUpdated_Week_4.pdf)

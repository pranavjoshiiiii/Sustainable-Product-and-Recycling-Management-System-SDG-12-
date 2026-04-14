# CRC Cards — Sustainable Product & Recycling Management System

---

## Run

| Responsibilities | Collaborators |
|---|---|
| Start the application | Menu |
| Initialise required system components | |
| Invoke Main to begin execution | |

---

## Menu

| Responsibilities | Collaborators |
|---|---|
| Display available options to the user | Main |

---

## Main

| Responsibilities | Collaborators |
|---|---|
| Run the program | Menu |

---

## User

| Responsibilities | Collaborators |
|---|---|
| Store user information (name, email, credentials) | ActivityLog |
| Provide user identity | |
| Allow access to user-specific actions | |

---

## ActivityLog

| Responsibilities | Collaborators |
|---|---|
| Record user activities | User |
| Store activity history | Product |
| Retrieve activity history for a user | |

---

## Product

| Responsibilities | Collaborators |
|---|---|
| Store product details (name, type, lifespan) | Material |
| Provide product-related information | |
| Link product to materials and impact data | |

---

## Material

| Responsibilities | Collaborators |
|---|---|
| Store name, impact value, and recycling instructions | Product |
| Know its recycling categories | RecyclingCategory |
| Be reusable across products | |

---

## RecyclingCategory

| Responsibilities | Collaborators |
|---|---|
| Classify material composition | Material |
| Carry a material label | RecyclingGuidance |
| Be stable and consistent across materials | |

---

## Impact

| Responsibilities | Collaborators |
|---|---|
| Compute an environmental impact score for a product | Product |
| Summarise impact results | Material |

---

## RecyclingGuidance

| Responsibilities | Collaborators |
|---|---|
| Derive recycling guidance for a product | RecyclingCategory |
| Handle material edge cases | Material |
| Combine rules across recycling categories | Product |

---

## ProductService

| Responsibilities | Collaborators |
|---|---|
| Create products | Product |
| List products | RecyclingGuidance |
| Show detailed product information | Impact |
| Request recycling guidance for a product | |

---

## MaterialService

| Responsibilities | Collaborators |
|---|---|
| Create materials | Material |
| List materials | Impact |

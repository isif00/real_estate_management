# Rapport sur le Logiciel de Gestion Immobilière

### Introduction :
Le logiciel de gestion immobilière que nous avons développé en Java utilise la programmation orientée objet (POO) pour fournir une solution complète pour la gestion des clients, des biens immobiliers, des transactions et des rendez-vous. Ce rapport présente la conception et la mise en œuvre des différentes classes utilisées dans le système, ainsi que leurs attributs, opérations et les relations entre elles.

### La Structure Du Projet :
#### 1. Classe Client

###### Attributs :

- `id` (String) : Identifiant unique du client.
- `name` (String) : Nom du client.
- `email` (String) : Adresse électronique du client.
- `phone` (String) : Numéro de téléphone du client.
- `city` (String) : Ville du client.
- `clientType` (ClientType) : Type de client (par exemple, acheteur, vendeur).
- `realEstateIds` (List<String>) : Liste des identifiants des biens immobiliers associés au client.
- `transactionIds` (List<String>) : Liste des identifiants des transactions associées au client.

###### Opérations :

- `Client getClient(String id)`: Récupère les informations d'un client par son identifiant.
- `void addClient(Client client)`: Ajoute un nouveau client au système.
- `void deleteClient(String id)`: Supprime un client du système par son identifiant.
- `void updateClient(String id, Client newClient)`: Met à jour les informations d'un client existant.
- `void addRealEstate(String id, String realEstateId)`: Ajoute un bien immobilier à la liste des biens d'un client.

###### 2. Classe RealEstate

###### Attributs :

- `ID` (String) : Identifiant unique du bien immobilier.
- `name` (String) : Nom du bien immobilier.
- `address` (String) : Adresse du bien immobilier.
- `description` (String) : Description du bien immobilier.
- `state` (String) : État du bien immobilier (par exemple, neuf, ancien).
- `price` (int) : Prix du bien immobilier.
- `availability` (PropertyAvailability) : Disponibilité du bien (par exemple, disponible, vendu).
- `listingType` (ListingType) : Type d'annonce (par exemple, vente, location).
- `ownerId` (String) : Identifiant du propriétaire du bien immobilier.

#### Opérations : 

- `List<RealEstate> getRealEstates()`: Récupère la liste de tous les biens immobiliers.
- `void addRealEstate(RealEstate realEstate)`: Ajoute un nouveau bien immobilier au système.
- `void deleteRealEstate(String id)`: Supprime un bien immobilier du système par son identifiant.
- `void updateRealEstate(String id, RealEstate newRealEstate)`: Met à jour les informations d'un bien immobilier existant.
- `RealEstate getRealEstate(String id)`: Récupère les informations d'un bien immobilier par son identifiant.





#### 3. Classe Transaction

###### Attributs : 

- `ID` (String) : Identifiant unique de la transaction.
- `realestate` (RealEstate) : Bien immobilier concerné par la transaction.
- `client` (Client) : Client impliqué dans la transaction.
- `transactionType` (TransactionType) : Type de transaction (par exemple, achat, location).
- `transactionFee` (int) : Frais de transaction.

###### Opérations : 

- `List<Transaction> getTransactions()`: Récupère la liste de toutes les transactions.
- `void addTransaction(Transaction transaction)`: Ajoute une nouvelle transaction au système.
- `void deleteTransaction(String id)`: Supprime une transaction du système par son identifiant.
- `Transaction getTransaction(String id)`: Récupère les informations d'une transaction par son identifiant.

#### 4. Classe Appointment

###### Attributs : 

- `id` (String) : Identifiant unique du rendez-vous.
- `client` (Client) : Client concerné par le rendez-vous.
- `date` (String) : Date du rendez-vous.

###### Opérations : 

- `Appointment getAppointment(String id)`: Récupère les informations d'un rendez-vous par son identifiant.
- `List<Appointment> getAppointments()`: Récupère la liste de tous les rendez-vous.
- `void addAppointment(Appointment appointment)`: Ajoute un nouveau rendez-vous au système.
- `void deleteAppointment(String id)`: Supprime un rendez-vous du système par son identifiant.

### Relations entre les Classes : 

###### Relation Client-RealEstate :
- Type : Association (1-*).
- Description : Un client peut être associé à plusieurs biens immobiliers. Cette relation est représentée par la liste `realEstateIds` dans la classe `Client`, qui contient les identifiants des biens immobiliers possédés ou intéressés par le client.

###### Relation RealEstate-Client :
- Type : Association (1-1).
- Description : Chaque bien immobilier est détenu par un seul propriétaire. L'attribut ownerId dans la classe RealEstate fait référence à l'identifiant unique du client qui est propriétaire de ce bien.


###### Relation Client-Transaction :
- Type : Association (1-*).
- Description : Un client peut effectuer plusieurs transactions. Cette relation est représentée par la liste `transactionIds` dans la classe `Client`, qui contient les identifiants des transactions effectuées par le client.


###### Relation Transaction-Client :
- Type : Association (2-2).
- Description : Chaque transaction implique deux client. L'attribut client dans la classe Transaction fait référence à l'objet Client impliqué dans cette transaction.


###### Relation RealEstate-Transaction 
Type: Association (1-*).
Description: Un bien immobilier peut être associé à plusieurs transactions. Cette relation est représentée par la liste transactionIds dans la classe RealEstate, qui contient les identifiants des transactions impliquant ce bien immobilier.


###### Relation Transaction-RealEstate
Type: Association (1-1).
Description: Chaque transaction est associée à un seul bien immobilier. L'attribut realestate dans la classe Transaction fait référence à l'objet RealEstate concerné par cette transaction.


###### Relation Client-Appointment :
- Type : Association (1-*).
- Description : Un client peut avoir plusieurs rendez-vous. Cette relation est représentée par l'attribut `client` dans la classe `Appointment`, qui fait référence à un objet `Client`.

#### Diagramme De Classe : 
![image](https://github.com/isif00/real_estate_management/assets/116845247/19420f0c-3ee1-423f-8ae3-dada4e6330da)


#### Architecture D'informations : 
![image](https://github.com/isif00/real_estate_management/assets/116845247/64b4290b-384b-4b0e-bcae-c6a273b25768)


## Microsoft Hackathon 2020

## Project Team Name - Spartan

## Project description

It helps to search any structured or unstructured files from azure blob storage using Azure cognitive services. Cognitive search is a new generation of enterprise search that uses artificial intelligence technologies to improve user's search queries and extract relevant information from multiple, diverse data sets. Cognitive search capabilities extend beyond those of a classic search engine to bring numerous data sources together while also providing automated tagging and personalization. It has the potential to greatly improve how an organization's employees discover and access information relevant and necessary to their work context.

## Current Problems

We usually use to search document or any files by using common webservices which in turn connect with external datasource to load blob file sequentially.
Whenever customer want to load multiple relevant files on the same time, it cannot be done using current solution. Probably, we have to make multiple HTTP calls from UI. It also stick with single search concept and we cannot leverage to push multiple search concept by using personalization.

## Solutions

This solution is develop based on cognitive services based on AI enrichment. It helps to load one or more matches files from Azure blob storage at the same time. It uses to find relevant files by using search text and once it happens file name, content and contentType. Which will be shown on the UI with list of files been match. 

Where customer can go and download the files by clicking on the file name.


## High Level Architecture Diagram
![azure-ai-cognitive-serach-xenonstack](https://user-images.githubusercontent.com/52231685/78991118-d1c4e580-7b55-11ea-97ec-3dbf4391ee2b.png)

## Step Flow
### Flow
* Create Azure blob storage on portal
* Upload the files which ever needed for searching purpose on azure blob storage
* Create Cognitive service on portal
* Once cognitive service successfully created, start import the data.
* To import the data, first we need to create datasource on cognitive service to interact with azure blob storage
* Create indexes to define list of field been used as a response.
* Create Skillset for enabling AI enrichment
* Create indexer to define mapping between skillset, indexes and datasource.
* Finally, you can use indexer REST url to verify the search.
* Integrate cognitive search from UI application

## Technical Diagram
![download](https://user-images.githubusercontent.com/52231685/78991263-2c5e4180-7b56-11ea-9141-4573584b6ca7.png)

## Included components

* [Azure blob storage](https://azure.microsoft.com/en-in/services/storage/blobs/): Store any type of unstructured data—including images, videos, audio, documents and backups—with proven technology at exabyte scale. Blob storage handles trillions of stored objects, with millions of average requests per second, for customers around the world.

* [Azure cognitive services](https://azure.microsoft.com/en-in/services/cognitive-services/): Cognitive Services bring AI within reach of every developer—without requiring machine-learning expertise. All it takes is an API call to embed the ability to see, hear, speak, search, understand and accelerate decision-making into your apps.


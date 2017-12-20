# OpenCompare Api

The OpenCompare Api enables us to manipulate json files which are taken from the OpenCompare2 api and transform them into PCM's( as Java Objects), then we can use these PCM's to export them as JSON. Therefore, we can compare both JSON'(The one imported with the one exported).This project involves students at University of Rennes 1 (ISTIC).

## Development tools

* [IntellJ IDEA](https://www.jetbrains.com/idea/) - Java integrated development environment 
* [Maven](https://maven.apache.org/) - Java integrated development environment 


## Libraries And depedencies

* [JsonLibrary](http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm) - Json Java library
* [JacksonLibrary](http://www.java2s.com/Code/Jar/j/Downloadjacksonmapperasl120jar.htm) - Jackson library

```
These libraries are already present in the pom XML since we are also using Maven.
```


## Getting Started

* You can copy the link of the json from the website [OpenCompare2](https://opencompare.org/).
```
It should look like this : https://opencompare.org/pcm/5a17ec1e086cfd088ff72de9
```
* Use the link to generate the PCM.
```
In the class ApiOpenCompare paste the link.
```
* Run the application then you will get the PCM (java objects).

* Export your PCM into Json format and test if the Json imported is similar to the Json exported
```
You can  use the jackson library to check their similarity 
```

## Result

It is now possible to import Json and transofrm them into PCM using the Java Api, and using these PCMs to generate a Json file.
It is also possible to check the similarity between two Json's files , the one imported and the one generated.
There is a new functionality that allows the client to modify the Source Json's, it is possible to make sure that an information has been changed by comparing both Json's


## License

This project is licensed under the Apache license  Version 2.0- see the [LICENSE.md](LICENSE.md) file for details

## Project architecture

[Architecture](https://imgur.com/a/zrEAI)

lien vers diagramme de classe : https://docs.google.com/document/d/1WGf0ZouYbzGmUSfyE67OmJXdn9nW_qgM40W0_lQ7z5w/edit?usp=sharing




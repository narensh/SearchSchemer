1. Introduction
SearchSchemer is a simple application which allows to convert
index structure between the following search engines:
 * Apache Solr (http://lucene.apache.org/solr/)
 * ElasticSearch (http://www.elasticsearch.org/)
 * SenseiDB (http://www.senseidb.com/)
 
2. Using SearchSchemer
To run SearchSchemer You should run the following command:
java -jar SearchSchemer.jar --inputFile <value> --inputType <value>
       --outputFile <value> --outputType <value>
where:
  * inputFile  - configuration file to read
  * inputType  - input configuration type 
  * outputFile - output configuration file
  * outputType - output configuration type

The inputType and outputType properties can take the following values:
 * solr          - for Solr schema.xml
 * elasticsearch - for ElasticSearch mappings file
 * senseidb      - for SenseiDB table definition 
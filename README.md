# elastic-clojure-demo

Demonstrates Elasticsearch integration with Clojure.

## Setup

   - Clone https://github.com/jasongilman/elastic-clojure-demo
     - `git clone https://github.com/jasongilman/elastic-clojure-demo.git`
   - Install the Elasticsearch Marvel plugin
     - `cd elastic-clojure-demo`
     - `lein install-marvel`
   - Start the REPL
     - `lein repl`
     - Run `(reset)`
   - Open `elastic-clojure-demo.core` and evaluate expressions in that file.
     - If you're not using a editor integrated REPL run `(in-ns 'elastic-clojure-demo.core)`
     - Then you can copy and past expressions into the REPL.


## Hack night TODOs

  * Setup the index for storing baseball players from `players.csv`
  * Extract data from `players.csv` using Clojure CSV and save to Elasticsearch.
  * Use Clojure and Elasticsearch to answer challenge questions.

### Challenge Questions

These are some questions to try and answer using Elasticsearch and Clojure. Questions must be answered by writing Clojure code that searches Elasticsearch.

  * Who was the tallest player?
  * Who was the heaviest player?
  * How many players are from Atlanta, GA born after 1970?
  * How many players are still alive?
  * How many players have a last name ending with "ner"?
  * What is the ratio of right handed to left handed players?
  * What is the combined weight of all players?
  * What year had the highest number of debuting players?

Bonus:

  * Using Incanter graph weights of players over the history of the sport.


## Useful documentation links

  * [Elastisch](http://clojureelasticsearch.info)
  * [Elastisch API](http://reference.clojureelasticsearch.info)
  * [Elasticsearch](http://www.elasticsearch.org/guide/en/elasticsearch/reference/current/index.html)
  * [Clojure CSV](https://github.com/clojure/data.csv)


## Baseball Player Data

The data in players.csv.zip is an excerpt of [Lahman's Baseball Database](http://seanlahman.com/baseball-archive/statistics). It is copyright 2014 Sean Lahman licensed under a Creative Commons Attribution-ShareAlike 3.0 Unported License.  For details see: [http://creativecommons.org/licenses/by-sa/3.0/](http://creativecommons.org/licenses/by-sa/3.0/).


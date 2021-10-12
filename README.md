# Word counting web api

This is a demo app created just for learning purposes.

## What

This is a web api that count words and returns the frequency of each word and is ordered based on quantity. 

Example of a query:

`curl -H "Content-type: text/plain" -X "POST" -d "Banan Apple Katt Hund Banan Hund Katt Hund" http://localhost:5000/count`

Expected result: 

`{"Hund":3,"Banan":2,"Katt":2,"Apple":1}`

## How

To get this server running follow these steps:

### Prerequisites 

1. Docker needs to be installed.

### Steps

1. Clone this git repository:  
`git clone git@github.com:paokarlsson/word-count-web-api.git`  

2. Open the terminal or the Command Prompt from inside the downloaded folder. 

3. Execute this command to build a docker image:  
`docker build --tag text-ana-img .`

4. Execute this command to start a container from that image:  
`docker run -dp 5000:5000 --name text-ana-cont text-ana-img`

5. Test a query: `curl -H "Content-type: text/plain" -X "POST" -d "Banan Apple Katt Hund Banan Hund Katt Hund" http://localhost:5000/count`

Enjoy!
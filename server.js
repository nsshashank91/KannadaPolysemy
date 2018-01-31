var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var fs = require('fs');
var encoding = require('encoding');
//app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.post('/', function(req, res) {
  console.log("request received");
  res.setHeader('Access-Control-Allow-Origin','*');
});

app.post('/send_save', function(req, res) {
    var txt = req.body.data;
    fs.writeFileSync('message.txt','');
    txt.forEach(function(value){
        console.log(value);
        fs.appendFileSync('message.txt',value.posWord);
        fs.appendFileSync('message.txt',"::::::");
        fs.appendFileSync('message.txt',value.synWords);
        fs.appendFileSync('message.txt',"::::::");
        fs.appendFileSync('message.txt',value.gloss);
        fs.appendFileSync('message.txt',"----------------------------");

    });
    

    

});

app.listen(3000);
console.log("server running on 3000");
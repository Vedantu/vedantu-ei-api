#!/bin/bash

echo "====================================";
echo "[authenticate]";
time(curl -X POST -H "Content-Type: application/json" -d '{"username" : "MBA2013999", "password" : "somesecret"}' http://localhost:8080/vedantu-ei-api/authenticate)
echo "------------------------------------";

echo ;

echo "====================================";
echo "[uploadTestAttemptData]";
time(curl -X POST -H "Content-Type: application/json" -d '{"uploadId" : "abscd123", "attempts" : [ {"code" : "TEST-06", "userId" : "654321abc", "attemptId" : "dcesc12345dc","answers" : [{ "questionNumber" : 1, "isCorrect" : true, "userScore" : 5, "maxScore" : 5 }] }]}' http://localhost:8080/vedantu-ei-api/uploadTestAttemptData)
echo "------------------------------------";

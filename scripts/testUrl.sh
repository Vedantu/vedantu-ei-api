#!/bin/bash

echo "====================================";
echo "[register - already registered]";
time(curl -X POST -H "Content-Type: application/json" -d '{"username" : "MBA2013999", "password" : "somesecret", "firstName" : "Anthony", "role" : "STUDENT", "additionalInfo" : {"CAT Roll Number" : "CAT-2013-111"}}' http://localhost:8080/vedantu-ei-api/register)
echo "------------------------------------";

echo ;

echo "====================================";
echo "[register - missing parameters]";
time(curl -X POST -H "Content-Type: application/json" -d '{"username" : "MBA2013000", "password" : "somesecret", "firstName" : "Anthony", "role" : "STUDENT", "additionalInfo" : {"Father Name" : "Puppa"}}' http://localhost:8080/vedantu-ei-api/register)
echo "------------------------------------";

echo ;

echo "====================================";
echo "[register - success]";
time(curl -X POST -H "Content-Type: application/json" -d '{"username" : "MBA2013000", "password" : "somesecret", "firstName" : "Anthony", "role" : "STUDENT", "additionalInfo" : {"CAT Roll Number" : "CAT-2013-111"}}' http://localhost:8080/vedantu-ei-api/register)
echo "------------------------------------";

echo ;


echo "====================================";
echo "[authenticate]";
time(curl -X POST -H "Content-Type: application/json" -d '{"username" : "MBA2013999", "password" : "somesecret"}' http://localhost:8080/vedantu-ei-api/authenticate)
echo "------------------------------------";

echo ;

echo "====================================";
echo "[uploadTestAttemptData - invalid userId and test code]";
time(curl -X POST -H "Content-Type: application/json" -d '{"uploadId":"abscd123","attempts":[{"code":"TEST-03","userId":"user123","attemptId":"12345dc123","maxScore":100,"userScore":50,"attemptStartTime":1387196796000,"attemptEndTime":1387196856000,"answers":[{"questionNumber":1,"isAttempted":true,"userAnswer":"1,3","isCorrect":true,"userScore":5,"maxScore":5,"timeTaken":5000},{"questionNumber":2,"isAttempted":true,"userAnswer":"25","isCorrect":true,"userScore":5,"maxScore":5,"timeTaken":5000}]},{"code":"TEST-07","userId":"654321abc","attemptId":"dcesc12345dc","maxScore":100,"userScore":50,"attemptStartTime":1387196796000,"attemptEndTime":1387196856000,"answers":[{"questionNumber":1,"isAttempted":true,"userAnswer":"1,3","isCorrect":true,"userScore":5,"maxScore":5,"timeTaken":5000}]}]}' http://localhost:8080/vedantu-ei-api/uploadTestAttemptData)
echo "------------------------------------";


echo "====================================";
echo "[uploadTestAttemptData - success]";
time(curl -X POST -H "Content-Type: application/json" -d '{"uploadId" : "abscd123", "attempts" : [ {"code" : "TEST-03", "userId" : "654321abc", "attemptId" : "dcesc12345dc","maxScore" : 100, "userScore": 50, "attemptStartTime" : 1387196796000, "attemptEndTime" : 1387196856000, "answers" : [{ "questionNumber" : 1,"isAttempted" : true, "userAnswer" : "1,3", "isCorrect" : true, "userScore" : 5, "maxScore" : 5, "timeTaken": 5000 }] }]}' http://localhost:8080/vedantu-ei-api/uploadTestAttemptData)
echo "------------------------------------";





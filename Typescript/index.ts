/**
* This is the rock,
* paper, scissors program.
*
* By:Evan Beaudoin
* Version: 1.0
* Since:   2024-03-06
 */

import { createPrompt } from 'bun-promptx'


// This function gets the computer's choice.
function getComputerChoice(rock, paper, scissors) {
  const min = 0
  const max = 2
  const randomNumber = Math.floor(Math.random() * (max - min + 1) + min)
  const rockPaperScissorsArray = [rock, paper, scissors]
  const computerChoice = rockPaperScissorsArray[randomNumber]

  return computerChoice
}

function getPlayerChoice() {
  let playerChoice = createPrompt("Choose: Rock, Paper or Scissors -->: ").value
  playerChoice = playerChoice.toUpperCase()
  return playerChoice
}


function getResult(playerChoice, computerChoice) {
  let playerWon = false
  
  if (playerChoice == rock && computerChoice == scissors) {
    playerWon = true
  }
  else if (playerChoice == paper && computerChoice == rock) {
    playerWon = true  
  }
  else if (playerChoice == scissors && computerChoice == paper) {
    playerWon = true  
  }
  else {
    playerWon = false
  }
  return playerWon
}

console.log("Type 'exit' to quit the loop\n")


// variables
let score = 0
const rock = "ROCK"
const paper = "PAPER"
const scissors = "SCISSORS"

//Process & Error handling & Output
while (true) {
  const playerChoice = getPlayerChoice()
  const computerChoice = getComputerChoice(rock, paper, scissors)

  if (playerChoice == "EXIT") {
    break
  }
  if (playerChoice != rock && playerChoice != paper && playerChoice != scissors) {
    
    console.log("\nInvalid input. Please choose Rock, Paper, or Scissors!")
    continue
  }

  const playerWon = getResult(playerChoice, computerChoice)
    
  console.log("Computer chose: " + computerChoice)
    
  if (playerWon == true) {
    console.log("\nYou won!")
    score += 1

  }
  else if (playerChoice == computerChoice) {
    console.log("\nYou Tied!")
  }
  else if (playerWon == false){
    console.log("\nYou lost!")
  }

  console.log("\nScore: " + score)
}
console.log("\nDone.")


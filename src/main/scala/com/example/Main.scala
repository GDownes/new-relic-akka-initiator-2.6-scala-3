package com.example

import akka.actor.{ActorSystem, Props}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object Main {
  val system = ActorSystem("InitActorSystem")

  def main(args: Array[String]): Unit = {
    var referee = system.actorSelection("akka.tcp://MyActorSystem@localhost:2553/user/referee")
    println("Sending message to remote actor")
    referee ! "Start Game"

    // We need this sleep to ensure the message above gets sent before we shutdown this system.
    Thread.sleep(1000)

    system.terminate()
  }
}

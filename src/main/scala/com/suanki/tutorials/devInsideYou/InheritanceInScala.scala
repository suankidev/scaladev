package com.suanki.tutorials.devInsideYou

trait Device {

  val wattPerSecond: Double

  def turnedOn(): Unit

  def turnedOff(): Unit

}

class EnergyMeter(device: Device) {
  private[this] var turnedOnAtMillis: Long       = 0
  private[this] var _wattConsumedInTotal: Double = 0

  private[this] def wattsConsumedInTotal_=(newValue: Double): Unit = _wattConsumedInTotal = newValue

  def startMeasuring(): Unit = {
    device.turnedOn()
    turnedOnAtMillis = System.currentTimeMillis
  }

  def stopMeasuring(): Unit = {
    device.turnedOff()
    val durationInMillis  = System.currentTimeMillis - turnedOnAtMillis
    val durationInSeconds = durationInMillis.toDouble / 1000

    wattsConsumedInTotal_=(_wattConsumedInTotal + (device.wattPerSecond * durationInSeconds))
  }

}

object InheritanceInScala {}

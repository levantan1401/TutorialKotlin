package com.example.tutorial

fun main() {
    val deviceManagerA = DeviceManager()
    val deviceManagerB = DeviceManager()

    // add device
    var lightA1 = Light(1,"Bong den huynh quang", "binh minh", 10000, )
    lightA1.setLight(lightPower = true, color = 123431, brightNess = "100W")
    var lightA2 = Light(2, "Den ngu", "binh minh", 2000)
    lightA2.setLight(lightPower = true, color = 1431, brightNess = "10W")

    var camera = Camera(3,"A73", "Sony", 32000000)
    camera.setRotespeed(100)

    var camera1 = Camera(4,"A74", "Sony", 52000000)
    camera1.setRotespeed(300)

    // add data to deviceManage
    deviceManagerA.addDevice(lightA1)
    deviceManagerA.addDevice(camera1)

    deviceManagerB.addDevice(lightA2)
    deviceManagerB.addDevice(camera)

    // Get device list info

    println(">>>>>>> DEVICE A: \n")
    deviceManagerA.getInfoDevice()

    println(">>>>>>> DEVICE B: \n")
    deviceManagerB.getInfoDevice()

    // Remove Device
    println("\n>>>>>> REMOVE A1\n")
    deviceManagerA.removeDeviceById(4)

    println("\nSAU KHI REMOVE A1\n")
    println(">>>>>>> DEVICE A: \n")
    deviceManagerA.getInfoDevice()


    println("\n UPDATE DEVICEB\n")
    val newCamera = Camera(10101, "SONYYYYYY", "CAMERA SOINY", 1988989)
    newCamera.setRotespeed(10000)
    deviceManagerB.updateDeviceById(3, newCamera)
    println("\nSAU KHI UPDATE\n")
    deviceManagerB.getInfoDevice()

}
//a) Tao 1 class Device
//có các thuộc tình là id, name, brand, price
//Các hành vi setInfo, getInfo
open class Device(
     private var id: Int = 0,
     private var name: String = "",
     private var brand: String = "",
     private var price: Int = 0
) {
    internal fun setInfo(id: Int, name: String, brand: String, price: Int){
        this.id = id
        this.name = name
        this.brand = brand
        this.price = price
    }

    internal open fun getInfo():String {
        return  "Thông tin \nID: $id \nName: $name \nBrand: $brand \nPrice: $price\n"
    }
    internal open fun getID():Int {
        return id;
    }
}

//b) Tạo 1 class Light kế thừa class Device
//có thuộc tính lightPower, color, brightNess
class Light(id: Int, name: String, brand: String, price: Int): Device(id, name, brand, price) {
    private var lightPower: Boolean = true
    private var color: Int = 0
    private var brightNess: String = ""

    override fun getInfo():String {
        val deviceInfo = super.getInfo()
        return "$deviceInfo, \nLIGHT INFO: \nLightPower: $lightPower, \nColor: $color, \nBrightNess: $brightNess "
    }
    internal fun setLight(lightPower: Boolean, color: Int, brightNess: String){
        this.lightPower = lightPower
        this.brightNess = brightNess
        this.color = color
    }
}

//c) Tạo 1 class Camera kế thừa Device
//có thuộc tính rotateSpeed
class Camera(id: Int, name: String, brand: String, price: Int): Device(id, name, brand, price){
    private var rotateSpeed:Int = 0

    override fun getInfo(): String {
        val device = super.getInfo()
        return "$device \nRotateSpeed: $rotateSpeed"
    }
    internal fun setRotespeed(rotateSpeed:Int){
        this.rotateSpeed = rotateSpeed
    }
}

//d) Tạo 1 class DeviceManager
//thuộc tính home
//+ add 1 device
//+ remove 1 device by id
//+ update 1 device by id
//+ getInfo deviceList

class DeviceManager {
    private val home = mutableListOf<Device>()
    fun addDevice(device: Device) {
        home.add(device)
    }
    fun removeDeviceById(id:Int){
        val iterator = home.iterator()
        while (iterator.hasNext()){
            val device = iterator.next()
            if(device.getID() == id){
                iterator.remove();
                println("DA XOA ID: ${id}")
                break
            }
        }
    }

    fun updateDeviceById(id: Int, newDevice: Device) {
        for(i in 0 until home.size){
            if(home[i].getID() == id){
                home[i] == newDevice
                break
            }
        }
    }

    fun getInfoDevice(){
        if (home.isEmpty()){
            print("List Empty, add item to list")
        }else{
            for (item in home) {
                print("\n${item.getInfo()}")
            }
        }
    }
}





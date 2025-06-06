package com.example.app_du_lich.RetrofitClient

import android.content.Context
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.*

object IPHelper {
    fun getLocalIpAddress(): String {
        try {
            val interfaces = NetworkInterface.getNetworkInterfaces()
            for (intf in Collections.list(interfaces)) {
                val addrs = intf.inetAddresses
                for (addr in Collections.list(addrs)) {
                    if (!addr.isLoopbackAddress && addr is InetAddress) {
                        val ip = addr.hostAddress
                        if (!ip.contains(":")) { // IPv4 only
                            return ip
                        }
                    }
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return "127.0.0.1" // fallback IP
    }
}
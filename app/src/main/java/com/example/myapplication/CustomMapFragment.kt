package com.example.myapplication

import android.content.Context
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CustomMapFragment: SupportMapFragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMapLoadedCallback {
            zoomToHamburgBounds()
        }
    }

    private fun zoomToHamburgBounds() {
        val hamburgBounds = LatLngBounds.Builder()
            .include(LatLng(53.394655, 10.099891))
            .include(LatLng(53.694865, 9.757589))
            .build()

        map.animateCamera(CameraUpdateFactory.newLatLngBounds(hamburgBounds, 10))
    }
}
package com.app.mobile

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.app.mobile.databinding.ActivityHomeBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MainActivity : AppCompatActivity() {
    private var _bindingHome: ActivityHomeBinding? = null
    private val bindingHome
        get() = _bindingHome ?: throw IllegalStateException("Binding for ActivityHomeBinding must not be null")


    private lateinit var mapView:MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _bindingHome = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bindingHome.root)



        MapKitFactory.setApiKey("")
        MapKitFactory.initialize(this@MainActivity)
        setContentView(R.layout.activity_home)

        mapView = findViewById(R.id.map_view)
        mapView.getMap().setNightModeEnabled(true);
        mapView.map.move(
            CameraPosition(Point(55.75, 37.57), 13.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0f),
            null
        )
        mapView.getMap().isZoomGesturesEnabled()
        mapView.getMap().isRotateGesturesEnabled()
        mapView.getMap().isScrollGesturesEnabled()
        mapView.getMap().isTiltGesturesEnabled()
        mapView.getMap().isRotateGesturesEnabled()

    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        mapView.onStop()
    }
}
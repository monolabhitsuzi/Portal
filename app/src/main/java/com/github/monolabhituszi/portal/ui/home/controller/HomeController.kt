package com.github.monolabhituszi.portal.ui.home.controller
//
// import com.airbnb.epoxy.TypedEpoxyController
// import com.github.monolabhituszi.portal.itemTimetable
// import com.github.monolabhituszi.portal.model.SampleHomeModel
// import com.github.monolabhituszi.portal.ui.home.HomeFragment
//
// class HomeController : TypedEpoxyController<List<SampleHomeModel>>() {
//    override fun buildModels(data: List<SampleHomeModel>?) {
//        requireNotNull(data)
//        if (data.isEmpty()) return
//
//        data.forEachIndexed { index, sampleHomeModel ->
//            val title = sampleHomeModel.name
//            val description = sampleHomeModel.description
//            val weekday = sampleHomeModel.weekday
//            val time = sampleHomeModel.time
//            val location = sampleHomeModel.location
//
//            requireNotNull(weekday)
//            requireNotNull(time)
//            itemTimetable {
//                id("$index")
//                title(title)
//                description(description)
//                weekday(HomeFragment.weekdays[weekday])
//                time(time)
//                location(location)
//            }
//        }
//    }
// }

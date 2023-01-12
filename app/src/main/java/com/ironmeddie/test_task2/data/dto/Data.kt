package com.ironmeddie.test_task2.data.dto

import com.ironmeddie.test_task2.common.utils.UtilConstants.BASE_URL
import com.ironmeddie.test_task2.domain.models.ItemData
import com.ironmeddie.test_task2.domain.models.NewPrice

data class Data(
    val CATALOG_AVAILABLE: String,
    val CATALOG_CAN_BUY_ZERO: String,
    val CATALOG_CAN_BUY_ZERO_ORIG: String,
    val CATALOG_HEIGHT: String,
    val CATALOG_LENGTH: String,
    val CATALOG_MEASURE: String,
    val CATALOG_NEGATIVE_AMOUNT_ORIG: String,
    val CATALOG_NEGATIVE_AMOUNT_TRACE: String,
    val CATALOG_PRICE_TYPE: String,
    val CATALOG_PURCHASING_CURRENCY: String,
    val CATALOG_PURCHASING_PRICE: String,
    val CATALOG_QUANTITY: Int,
    val CATALOG_QUANTITY_RESERVED: String,
    val CATALOG_QUANTITY_TRACE: String,
    val CATALOG_QUANTITY_TRACE_ORIG: String,
    val CATALOG_RECUR_SCHEME_LENGTH: String,
    val CATALOG_RECUR_SCHEME_TYPE: String,
    val CATALOG_SELECT_BEST_PRICE: String,
    val CATALOG_SUBSCRIBE: String,
    val CATALOG_SUBSCRIBE_ORIG: String,
    val CATALOG_TRIAL_PRICE_ID: Any,
    val CATALOG_TYPE: String,
    val CATALOG_VAT: String,
    val CATALOG_VAT_INCLUDED: String,
    val CATALOG_WEIGHT: String,
    val CATALOG_WIDTH: String,
    val CATALOG_WITHOUT_ORDER: String,
    val COUTCOMMENTS: String,
    val DATE_ACTIVE_FROM: Any,
    val DETAIL_PICTURE: String,
    val EDINICAIZMERENIYA: Any,
    val EXTENDED_PRICE: List<EXTENDEDPRICE>,
    val FAVORITE: Boolean,
    val IBLOCK_ID: String,
    val ID: String,
    val KOFFICIENT: Int,
    val MORE_PHOTO: MOREPHOTO,
    val NALICHIE: NALICHIE,
    val NAME: Any?  ,
    val NewPrice: NewPrice?,
    val PROPERTY_NEWPRODUCT_ENUM_ID: Any,
    val PROPERTY_NEWPRODUCT_VALUE: Any,
    val PROPERTY_NEWPRODUCT_VALUE_ID: Any,
    val PROPERTY_PODAROK_ENUM_ID: Any,
    val PROPERTY_PODAROK_VALUE: Any,
    val PROPERTY_PODAROK_VALUE_ID: Any,
    val PROPERTY_RATING_VALUE: Double,
    val PROPERTY_RATING_VALUE_ID: String,
    val PROPERTY_SALELEADER_ENUM_ID: String,
    val PROPERTY_SALELEADER_VALUE: String,
    val PROPERTY_SALELEADER_VALUE_ID: String,
    val PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE: Int,
    val PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE_ID: String,
    val PROPERTY_ZALOG_VALUE: Int
){
    fun toItemData(): ItemData{
        return ItemData(
            id = ID,
            picture = BASE_URL + DETAIL_PICTURE,
            morePhoto = MORE_PHOTO.VALUE,
            nalichie = NALICHIE.toNalichie(),
            name = NAME.toString() ,
            rating = PROPERTY_RATING_VALUE,
            favorite = FAVORITE,
            extendedPrice = EXTENDED_PRICE.map { it.toExtendedPrice() }
        )
    }
}
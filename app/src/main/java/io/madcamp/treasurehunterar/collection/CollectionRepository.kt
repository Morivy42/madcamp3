package io.madcamp.treasurehunterar.collection

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CollectionRepository @Inject constructor(
    private val collectionService: CollectionService
) {

    suspend fun getCollectionById(id: String): Collection {
//        return collectionService.getCollectionById(collectionNum)
        return Collection(
            collectionNum = 1,
            name = "튀김소보로",
            shortDescription = "성심당 튀김소보로",
            longDescription = "1980년 탄생 소보로, 앙금빵, 도넛의 3단 합체빵. 하나의 빵으로 3가지 맛을 즐기실 수 있는 성심당 No.1 튀김소보로",
            imageUrl = "https://www.sungsimdangmall.co.kr/data/sungsimdang/goods/sungsimdang/big/IMG01.png"
        )
    }

    suspend fun getCollectionList(): List<Collection> {
        return listOf(
            Collection(
                collectionNum = 1,
                name = "튀김소보로",
                shortDescription = "성심당 튀김소보로",
                longDescription = "1980년 탄생 소보로, 앙금빵, 도넛의 3단 합체빵. 하나의 빵으로 3가지 맛을 즐기실 수 있는 성심당 No.1 튀김소보로",
                imageUrl = "https://www.sungsimdangmall.co.kr/data/sungsimdang/goods/sungsimdang/big/IMG01.png"
            ),
            Collection(
                collectionNum = 2,
                name = "튀김소보로",
                shortDescription = "성심당 튀김소보로",
                longDescription = "1980년 탄생 소보로, 앙금빵, 도넛의 3단 합체빵. 하나의 빵으로 3가지 맛을 즐기실 수 있는 성심당 No.1 튀김소보로",
                imageUrl = "https://www.sungsimdangmall.co.kr/data/sungsimdang/goods/sungsimdang/big/IMG01.png"
            ),
            Collection(
                collectionNum = 3,
                name = "튀김소보로",
                shortDescription = "성심당 튀김소보로",
                longDescription = "1980년 탄생 소보로, 앙금빵, 도넛의 3단 합체빵. 하나의 빵으로 3가지 맛을 즐기실 수 있는 성심당 No.1 튀김소보로",
                imageUrl = "https://www.sungsimdangmall.co.kr/data/sungsimdang/goods/sungsimdang/big/IMG01.png"
            ),
            Collection(
                collectionNum = 4,
                name = "튀김소보로",
                shortDescription = "성심당 튀김소보로",
                longDescription = "1980년 탄생 소보로, 앙금빵, 도넛의 3단 합체빵. 하나의 빵으로 3가지 맛을 즐기실 수 있는 성심당 No.1 튀김소보로",
                imageUrl = "https://www.sungsimdangmall.co.kr/data/sungsimdang/goods/sungsimdang/big/IMG01.png"
            ),
        )
    }
}
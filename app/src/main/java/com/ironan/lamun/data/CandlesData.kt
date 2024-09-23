package com.ironan.lamun.data

import com.ironan.lamun.model.Candle

class CandlesData {

    fun loadCandles() : List<Candle> {
        return listOf(
            Candle(name = "Coffee Sensation", description = "A vela aromática Coffee Sensation é perfeita para quem AMA café e gosta de aromas quentes e levemente adocicados"),
            Candle(name = "Pêssego Japonês Matsuri", description = "A vela aromática Matsuri - Pêssego Japonês é feita com um blend de cera vegetal, essências premium e pavio de algodão, tornando-a 100% biodegradável e sustentável."),
            Candle(name = "Bergamota e Alecrim", description = "Bergamota e alecrim - com notas verdes e o cítrico da bergamota e limão, esse aroma traz calma e concentração por conta do alecrim e lavanda compondo a essência."),
            Candle(name = "Gengibre e Especiarias", description = "Gengibre e especiarias - cítrica especiada, esse aroma é doce e aquece o ambiente. Acalma, traz aconchego e te transporta para as festas de fim de ano, com a casa cheia de comidinhas natalinas.")

        )
    }
}
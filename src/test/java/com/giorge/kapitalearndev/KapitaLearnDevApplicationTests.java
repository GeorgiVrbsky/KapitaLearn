package com.giorge.kapitalearndev;

import com.giorge.kapitalearndev.service.ExpenseService; // Důležité: Importujte vaši Service třídu
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KapitaLearnDevApplicationTests {

    // Vložíme instanci Service, kde je metoda variationPrice
    @Autowired
    private ExpenseService expenseService;

    @Test
    void contextLoads() {
        // Kontrolní test, že se Spring Boot kontext načetl
    }

    /**
     * Testuje, zda náhodně generovaná cena vždy spadá do definovaného rozsahu.
     */
//    @Test
//    void testVariationPriceIsWithinBounds() {
//        double basePrice = 5000.0;
//        double variationPercent = 0.20; // 20% variace
//
//        // Očekávané meze
//        double expectedMin = basePrice * (1 - variationPercent); // 4000.0
//        double expectedMax = basePrice * (1 + variationPercent); // 6000.0
//
//        // Spouštíme 1000 iterací pro dostatečné pokrytí náhodného výběru
//        for (int i = 0; i < 1000; i++) {
//
//            // Volání testované metody
//            int resultPrice = expenseService.variationPrice(basePrice, variationPercent);
//
//            // Ověření 1: Cena nesmí být menší než minimum
//            assertTrue(resultPrice >= expectedMin,
//                    "Cena " + resultPrice + " je pod minimální hranicí " + expectedMin);
//
//            // Ověření 2: Cena nesmí být větší než maximum
//            assertTrue(resultPrice <= expectedMax,
//                    "Cena " + resultPrice + " je nad maximální hranicí " + expectedMax);
//        }
//    }
//
//    /**
//     * Testuje okrajový případ, kdy variace je 0.0. Cena by měla být přesná.
//     */
//    @Test
//    void testZeroVariationReturnsBasePrice() {
//        double basePrice = 750.0;
//        double variationPercent = 0.0;
//
//        int resultPrice = expenseService.variationPrice(basePrice, variationPercent);
//
//        // Očekáváme přesnou základní cenu (zaokrouhlenou na int)
//        assertEquals(750, resultPrice, "Cena s 0% variací musí být rovna základní ceně.");
//    }
}
package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Exception() {
        TorpedoStore store = new TorpedoStore(0);
        assertThrows(IllegalArgumentException.class, () -> {store.fire(1);});
    }

    @Test
    void failure_Rate() {
        TorpedoStore store = new TorpedoStore(1, 1);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }

    @Test
    void isEmpty() {
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(false, store.isEmpty());
        store.fire(1);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void torpedoCount() {
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(1, store.getTorpedoCount());
        store.fire(1);
        assertEquals(0, store.getTorpedoCount());
    }
}

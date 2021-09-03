import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class SeriesTest {

    @Test
    fun `corner | span equals length`() = assertLSPEquals("29", 2, 18)

    @Test
    fun `numbers in order | span 2`() = assertLSPEquals("0123456789", 2, 72)

    @Test
    fun `span 2`() = assertLSPEquals("576802143", 2, 48)

    @Test
    fun `numbers in order | span 3`() = assertLSPEquals("0123456789", 3, 504)

    @Test
    fun `span 3`() = assertLSPEquals("1027839564", 3, 270)

    @Test
    fun `numbers in order | span 5`() = assertLSPEquals("0123456789", 5, 15120)

    @Test
    fun `corner | long source sequence`() = assertLSPEquals("73167176531330624919225119674426574742355349194934", 6, 23520)

    @Test
    fun `zeros | only`() = assertLSPEquals("0000", 2, 0)

    @Test
    fun `zeros | dense`() = assertLSPEquals("99099", 3, 0)

    @Test(expected = IllegalArgumentException::class)
    fun `reject | span longer than string length`() {
        lsp("123", 4)
    }

    @Test
    fun `corner | zero span on empty sequence`() = assertLSPEquals("", 0, 1)

    @Test
    fun `corner | zero span on not empty sequence`() = assertLSPEquals("123", 0, 1)

    @Test(expected = IllegalArgumentException::class)
    fun `reject | empty string and nonzero span`() {
        lsp("", 1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `reject | nondigits in source sequence`() {
        Series("1234a5", 1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `reject | negative span`() {
        lsp("12345", -1)
    }
}

private fun assertLSPEquals(input: String, span: Int, lsp: Long) {
    assertEquals(lsp(input, span), lsp)
}

private fun lsp(input: String, span: Int) = Series(input, span).getLargestProduct(span)
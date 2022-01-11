public class MessageUtilTest1 {
    MessageUtil messageUtil;
    private String reslut = "ola";

    @Before
    public void setUp() throws Exception {
        messageUtil = new MessageUtil(reslut);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printMessage() {
        Assert.assertEquals(reslut,messageUtil.printMessage());
    }
}
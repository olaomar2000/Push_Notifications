@RunWith(Parameterized.class)
public class MessageUtilTest2 {
    private String expactedReslut;
    private String reslut;
     MessageUtil messageUtil;

    public MessageUtilTest2(String expactedReslut, String reslut) {
        this.expactedReslut = expactedReslut;
        this.reslut = reslut;
    }

    @Before
    public void setUp() throws Exception {
        messageUtil = new MessageUtil(expactedReslut);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void welcomeMessage() {
        Assert.assertEquals(reslut,messageUtil.welcomeMessage());
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {"ola","Hi! ola"},
                {"omar","Hi! omar"},
        });
    }

}
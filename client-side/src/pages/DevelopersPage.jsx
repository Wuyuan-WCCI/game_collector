import wuyuanImg from '../img/Wuyuan.png';
import tionImg from "../img/Tion.jpeg";
import mikeImg from '../img/MikeV.jpeg';
import rayImg from "../img/ray- light.jpg";
import benImg from "../img/Ben.jpeg";

const DevelopersPage = () => {


    const developersData = [
        {
        name: "Tion Carter",
        role: "Front-end Developer",
        image: tionImg,
        email: "tioncarter@gmail.com",
        github: "https://github.com/Codename-Carter",
        bio: "My name is Tion Carter. Some people call me `T` for short. I was born and raised here in Richmond, Virginia—originally in the heart of the city before moving to the suburbs nearly a decade ago. Fullstack developer with no current specialty.",
        },
        {
        name: "Wuyuan Sun",
        role: "Full Stack Software Developer",
        image: wuyuanImg,
        email: "wuyuansed@gmail.com",
        github:"https://github.com/Wuyuan-WCCI",

        bio: "Hi, I'm Wuyuan, a dedicated full-stack software developer with expertise in Java Spring Boot and React for web development. Backed by a solid grasp of HTML, CSS, and JavaScript, I craft intuitive and visually appealing online experiences. Lets connect and explore how we can collaborate on your next web development venture!",
        },
        {
        name: "Raymond Samuel",
        role: "Front-end Developer",
        image: rayImg,
        email:"ray@amazon.com",
        github:'https://github.com/KRvision',
        bio: "Hello, my name is Ray and I'm a Software Developer. Here are a couple of links to my networking sites: GitHub and LinkedIn. Currently a beginner level front end developer and in pursuit of becoming a software developer with a knowledge base in Java programming language.",
        },
        {
        name: "Michael Vythilengam",
        role: "Back-end Developer",
        image: mikeImg,
        email: "michaelvythilengam@hotmail.com",
        github:"https://github.com/Miketb12",
        bio: "I'm Michael Vythilengam, studying CS at New Jersey Institute of Technology while working a full time job at Amazon. I work to the best of my abilites and hope to be a software engineer within the next year.",
        },
        {
        name: "Benjamin Pursley",
        role: "Full-Stack Developer",
        image: benImg,
        email: "ben@amazon.com",
        github:"https://github.com/BenjaminPursley",
        bio: "Current Amazon Learning Ambassador and former research biologist of 15 years. A natural problem solver with strong analytical abilities and a long track record of highly motivated, independently managed work. A jack-of-all-trades who is as comfortable poring over data sets from a desk as they are leading a team of workers on a warehouse floor.",
        }
    ];

    return (

        <>        <br></br>
        <h1 style={{color: '#87194c'}}>Meet the Developers</h1>
            <div className="developers-page">
    {developersData.map((developer, index) => (
        <div key={index} className="developer-card">
        <img src={developer.image} alt={developer.name} />
        <h2>{developer.name}</h2>
        <h5>Email: {developer.email}</h5>
        <h5>GitHub: {developer.github}</h5>
        <p>{developer.role}</p>
        <p>{developer.bio}</p>
        </div>
    ))}
    </div>

        </>
    )
    }
    export default DevelopersPage;
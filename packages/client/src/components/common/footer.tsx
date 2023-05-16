import Image from "next/image";

function Footer() {
  return (
    <footer className="bg-black text-white">
      <div className="p-10">
        <div className="grid gap-40 grid-cols-2">
          <div className="mb-6 md:mb-0 text-start">
            <div className="mb-5">
              <Image
                src="/images/footer_logo.svg"
                alt="footer-img"
                width={137}
                height={41}
              />
            </div>
            <p className="mb-4">Copyright Doffy. all rights reserved</p>
          </div>

          <div className="mb-6 md:mb-0 flex flex-col justify-end">
            <ul className="mb-5 flex flex-row justify-end">
              <li>이용약관</li>
              <li className="before:content-['|'] before:p-3">
                개인정보처리방침
              </li>
            </ul>
            <p className="mb-4 underline text-end">Get In Touch With Us</p>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;

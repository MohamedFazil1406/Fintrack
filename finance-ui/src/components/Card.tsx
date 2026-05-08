type Props = {
  title: string;
  amount: string;
};

const Card = ({ title, amount }: Props) => {
  return (
    <div className="bg-white p-5 rounded-xl shadow-sm hover:shadow-md transition flex-1">
      <p className="text-gray-400 text-sm">{title}</p>
      <h2 className="text-xl font-semibold mt-2">{amount}</h2>
    </div>
  );
};

export default Card;

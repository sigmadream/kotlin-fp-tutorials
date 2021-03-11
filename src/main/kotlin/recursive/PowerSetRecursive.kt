package recursive

//1. 함수원형
//fun <T> powerset(s: Set<T>): Set<Set<T>>

//2. 입력 조건 및 종료조건
//fun <T> powerset(s: Set<T>): Set<Set<T>> = when {
//    s.isEmpty() -> setOf(setOf())
//    else -> {
//        val head = s.first()
//        val restSet = powerset(s.drop(1))
//        restSet + restSet.map { setOf(head) + it }.toSet()
//    }
//}

//3. 꼬리재귀
//tailrec fun <T> powerset(s: Set<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
//    s.isEmpty() -> acc
//    else -> powerset(s.drop(1), acc + acc.map { it + s.first() })
//}

//4. 모든 컬렉션에 해당 함수를 사용할 수 있도록 등록
fun <T> Collection<T>.powerset(): Set<Set<T>> = powerset(this, setOf(setOf()))

tailrec fun <T> powerset(s: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
    s.isEmpty() -> acc
    else -> powerset(s.drop(1), acc + acc.map { it + s.first() })
}
